package webeng.tranferobjects;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String password;
	
	public User(){}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.password;
	}

	//TODO
	public boolean validate(){
		boolean valid = false;
		return valid;
	}
}
