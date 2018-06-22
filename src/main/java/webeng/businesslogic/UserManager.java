package webeng.businesslogic;

import java.util.List;

import webeng.access.DAOFactory;
import webeng.tranferobjects.User;


public class UserManager {

	public List<User> getAllUsers() {
		return DAOFactory.getUserDAO().getAllUsers();
	}

	public void addUser(User user) {
		DAOFactory.getUserDAO().addUser(user);
	}

	public User getUser(String name) {
		return DAOFactory.getUserDAO().getUser(name);
	}

	public void updateUser(User user, int id) {
		DAOFactory.getUserDAO().updateUser(user, id);
	}

	public boolean containsUser(int id) {
		List<User> users = this.getAllUsers();
		boolean userInList = false;

		for (User user : users) {
			if (user.getID() == id) {
				userInList = true;
			}
		}
		return userInList;
	}

	public void deleteUser(User user) {
		DAOFactory.getUserDAO().deleteUser(user);
	}
}
