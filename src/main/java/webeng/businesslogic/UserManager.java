package webeng.businesslogic;

import java.util.List;

import webeng.access.DAOFactory;
import webeng.tranferobjects.User;


public class UserManager {

	public List<User> getAllUsers() {
		return DAOFactory.getUserDAO().getAllUsers();
	}
	
	public List<User> findAllUsers(String userName) {
		return DAOFactory.getUserDAO().findAllUsers(userName);
	}

	public void addUser(User user) {
		DAOFactory.getUserDAO().addUser(user);
	}

	public User getUser(String name) {
		return DAOFactory.getUserDAO().getUser(name);
	}

	public void updateUser(User user, String name) {
		DAOFactory.getUserDAO().updateUser(user, name);
	}

	public boolean containsUser(String name) {
		List<User> users = this.getAllUsers();
		boolean userInList = false;

		for (User user : users) {
			if (user.getName() == name) {
				userInList = true;
			}
		}
		return userInList;
	}

	public void deleteUser(User user) {
		DAOFactory.getUserDAO().deleteUser(user);
	}
	
	
}
