package webeng.tranferobjects;

import java.io.Serializable;

public class User implements Serializable {
	
	private String name;
	private String password;
	private String email;

	public User() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}

	public boolean validate() {
		boolean valid = true;
		if (this.name == null || this.name.contains(" ")) {
			valid = false;
		}
		if (this.password == null || this.password.contains(" ")) {
			valid = false;
		}
		return valid;
	}

	private boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public boolean validatePassword(String password) {
		return (this.password.equals(password));
	}
}
