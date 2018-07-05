package webeng.presentation.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

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
		
		this.user = userManager.getUser(user.getName());
		
		if(user.validate())
		{
			//eigene Profilseite wird bei erfolgreichem Login zurückgegeben
			return "success";
		} else{
			//Fehler: Authentifizierung fehlgeschlagen
			return "failed";
		}	
	}

}
