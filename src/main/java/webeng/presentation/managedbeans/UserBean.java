package webeng.presentation.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import webeng.businesslogic.UserManager;
import webeng.tranferobjects.User;

@ManagedBean(name= "userBean")
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
			//eigene Profilseite wird bei erfolgreichem Login zurückgegeben
			return "success";
		} else{
			//Fehler: Authentifizierung fehlgeschlagen
			this.user= null; //?? Sonst wird Passwort und Name gespeichert
			return "failed";
		}	
	}
	

}
