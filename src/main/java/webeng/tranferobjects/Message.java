package webeng.tranferobjects;

import java.io.Serializable;

public class Message implements Serializable{

	private int id;
	private String message;
	private int likes;
	private int userID;
	//private Blob picture;
	
	public Message(){}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setLikes(int likes){
		this.likes = likes;
	}
	
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	//void setPicture(Blob picture){}
	
	public int getID(){
		return this.id;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public int getLikes(){
		return this.likes;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	//Blob getPicture(){}
	
	//TODO
	public boolean validate(){
		return false;
	}
}
