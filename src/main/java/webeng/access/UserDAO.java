package webeng.access;

import java.util.List;

import webeng.tranferobjects.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public void addUser(User u);
	public User getUser(String name);
	public void updateUser(User u, String name);
	public void deleteUser(User u);

}
