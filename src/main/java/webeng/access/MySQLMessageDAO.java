package webeng.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webeng.tranferobjects.Configuration;
import webeng.tranferobjects.Message;

public class MySQLMessageDAO implements MessageDAO {

	Connection con = Configuration.getConnection();

	@Override
	public List<Message> getAllMessages() {
		// Hier Methode für das Auslesen aller Artikel in der Datenbank
		List<Message> messages = new ArrayList<Message>();
		String query = "SELECT * FROM MESSAGES ORDER BY LIKES DESC";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Message message = new Message();
				
				message.setID(rs.getInt("id"));
				message.setMessage(rs.getString("message"));
				message.setLikes(rs.getInt("likes"));
				message.setUserName(rs.getString("username"));

				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(messages.size());
		return messages;
	}

	@Override
	public List<Message> findAllMessages(String userName) {
		// Hier Methode für das Auslesen aller Artikel in der Datenbank
		List<Message> messages = new ArrayList<Message>();
		String query = "SELECT * FROM MESSAGES WHERE username = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Message message = new Message();

				message.setID(rs.getInt("id"));
				message.setMessage(rs.getString("message"));
				message.setLikes(rs.getInt("likes"));
				message.setUserName(rs.getString("username"));

				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messages;
	}

	@Override
	public void addMessage(Message newMessage) {
		// Hier Methoden für das Inserten in die Datenbank
		String query = "INSERT INTO MESSAGES VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, newMessage.getID());
			stmt.setString(2, newMessage.getMessage());
			stmt.setInt(3, newMessage.getLikes());
			stmt.setString(4, newMessage.getUserName());

			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Message getMessage(int messageID) {
		// Hier Methode für das Auslesen aus der Datenbank
		Message message = new Message();
		String query = "SELECT * FROM MESSAGES WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, messageID);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				message.setID(rs.getInt("id"));
				message.setMessage(rs.getString("message"));
				message.setLikes(rs.getInt("likes"));
				message.setUserName(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void updateMessage(Message newMessage, int messageID) {
		// Hier Methode für das Aktualisieren in der Datenbank
		String query = "UPDATE MESSAGES SET message=? WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, newMessage.getMessage());
			stmt.setInt(2, messageID);

			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMessage(Message message) {
		// Hier Methoden für das Löschen in der Datenbank
		String query = "DELETE FROM MESSAGES WHERE id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, message.getID());

			int numberRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
