package webeng.tranferobjects;

import java.io.Serializable;

public class Message implements Serializable {

	private int id;
	private String message;
	private int likes;
	private int userID;
	//private Blob picture;

	public Message() {
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	//public void setPicture(Blob picture){
	//this.picture = picture;
	//}

	public int getID() {
		return this.id;
	}

	public String getMessage() {
		return this.message;
	}

	public int getLikes() {
		return this.likes;
	}

	public int getUserID() {
		return this.userID;
	}

	//public Blob getPicture(){
	//	return this.picture;
	//}

	public boolean validate() {
		boolean valid = true;

		if (this.id <= 0 || !isNumeric("" + this.id)) {
			valid = false;
		}
		if (this.message == null || this.message.equals(" ")) {
			valid = false;
		}
		if (this.likes < 0) {
			valid = false;
		}
		if (this.userID <= 0 || !isNumeric("" + this.id)) {
			valid = false;
		}
		return valid;
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
