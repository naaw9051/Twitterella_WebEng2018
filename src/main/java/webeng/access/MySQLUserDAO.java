package webeng.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webeng.tranferobjects.Configuration;
import webeng.tranferobjects.User;

public class MySQLUserDAO implements UserDAO {

	Connection con = Configuration.getConnection();

	@Override
	public List<User> getAllUsers() {
		// Hier Methode für das Auslesen aller Artikel in der Datenbank
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM USERS";

		try {
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void addUser(User newUser) {
		// Hier Methoden für das Inserten in die Datenbank
		String query = "INSERT INTO USERS VALUES (?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, newUser.getName());
			stmt.setString(2, newUser.getPassword());
			stmt.setString(3, newUser.getEmail());
			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public User getUser(String userName) {
		// Hier Methode für das Auslesen aus der Datenbank
		User user = new User();
		String query = "SELECT * FROM USERS WHERE name=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User newUser) {
		// Hier Methode für das Aktualisieren in der Datenbank
		String query = "UPDATE USERS SET password=? WHERE name=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, newUser.getPassword());
			stmt.setString(2, newUser.getName());

			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		// Hier Methoden für das Löschen in der Datenbank
		String query = "DELETE FROM USERS WHERE name=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user.getName());

			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findAllUsers(String userName) {
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM USERS WHERE name LIKE ?";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%"+ userName +"%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

}
