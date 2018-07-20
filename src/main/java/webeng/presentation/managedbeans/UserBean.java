package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.faces.bean.SessionScoped;
import webeng.businesslogic.UserManager;
import webeng.tranferobjects.User;

@ManagedBean(name= "userBean")
@SessionScoped
public class UserBean implements Serializable {
	
	static User loginUser;
	User user;
	UserManager userManager;
	List<User> users;
	String searchText;
	boolean loggedIn;
	boolean loggedInUser;
	
	public UserBean() {
		this.user = new User();
		this.userManager = new UserManager();
		this.searchText = "";
		this.users = new ArrayList<User>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public void setUsers(List<User> users){
		this.users = users;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void setSearchText(String searchText){
		this.searchText = searchText;
	}
	
	public String getSearchText(){
		return this.searchText;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public boolean isLoggedInUser() {
		boolean logged = false;
		
		if(loginUser != null && this.user.getName().equals(loginUser.getName())){
			logged = true;
		}
		else {
			logged = false;
		}
		return logged;
	}

	public void setLoggedInUser(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
		
	public String save(){
		userManager.addUser(user);
		return "";
	}
	
	public String login(){
		//Eingegebenes Passwort speichern
		String typedpassword = this.user.getPassword();
		
		User userToBeValidated = userManager.getUser(user.getName());
		
		if(userToBeValidated.validate() && userToBeValidated.validatePassword(typedpassword))
		{
			setLoggedIn(true);
			loginUser = this.user;
			//eigene Profilseite wird bei erfolgreichem Login zurückgegeben
			return "success";
		} else{
			setLoggedIn(false);
			//Fehler: Authentifizierung fehlgeschlagen
			this.user = new User(); 
			return "failed";
		}	
	}
	
	public String logout() {
		setLoggedIn(false);
		this.user = new User();
		loginUser = this.user;
		return "LogoutPage.xhtml";
	}
	
	public String register() {
		if(nameIsValid(this.user.getName())) {
			this.userManager.addUser(this.user);
			this.user = new User();
			return "success";
		}
		else {
			return "failed";
		}
	}
	
	public String reset() {
		this.user= new User();
		return "RegistrationPage.xhtml";
	}
	
	public boolean nameIsValid(String name) {
		List<User> userList = userManager.getAllUsers();
		boolean nameIsValid = true;
		
		for(User user: userList) {
			if(user.getName().equals(name)) {
				nameIsValid = false; 
			}
		}
		return nameIsValid;
	}
	
	
	public void validateName(FacesContext ctx, UIComponent ui, Object value)
			throws ValidatorException {
		
		if(!nameIsValid((String) value)) {
			throw new ValidatorException(new FacesMessage("Benutzername existiert bereits.",
					"Benutzername existiert bereits."));
		}
	}
	
	public void validateMail(FacesContext ctx, UIComponent ui, Object value)
			throws ValidatorException {
		
		String mail = (String) value;
		
		if(!(mail.contains("@"))) {
			throw new ValidatorException(new FacesMessage("E-Mail ungültig.",
					"E-Mail ungültig."));
		}
	}
	
	public String openProfile(String userName) {
		User user = this.userManager.getUser(userName);
		setUser(user);
		return "ProfilePage.xhtml";
	}
	
	public String openOwnProfile() {
		if(loggedIn) {
			setUser(loginUser);
			return "ProfilePage.xhtml";
		}
		else {
			return "login.xhtml";
		}
	}

	public void searchListener(AjaxBehaviorEvent e) {
		setUsers(this.userManager.findAllUsers(getSearchText()));
	}
}
