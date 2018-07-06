package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import javax.faces.bean.SessionScoped;
import webeng.businesslogic.UserManager;
import webeng.tranferobjects.User;

@ManagedBean(name= "userBean")
@SessionScoped
public class UserBean implements Serializable {
	
	User user = new User();
	UserManager userManager = new UserManager();
	
	void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public String save(){
		userManager.addUser(user);
		return "";
	}
	
	public String login(){
		
		System.out.println("////////////////////////////////////////Login");
		//Eingegebenes Passwort speichern
		String typedpassword = this.user.getPassword();
		
		User userToBeValidated = userManager.getUser(user.getName());
		
		if(userToBeValidated.validate() && userToBeValidated.validatePassword(typedpassword))
		{
			//eigene Profilseite wird bei erfolgreichem Login zur�ckgegeben
			return "success";
		} else{
			//Fehler: Authentifizierung fehlgeschlagen
			this.user= null; //?? Sonst wird Passwort und Name gespeichert
			return "failed";
		}	
	}
	
	public String logout() {
		this.user = null;
		return "LogoutPage.xhtml";
	}
	
	public String register() {
		if(nameIsValid(this.user.getName())) {
			this.userManager.addUser(this.user);
			this.user = null;
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
	

}
