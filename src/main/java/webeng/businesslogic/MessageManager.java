package webeng.businesslogic;

import java.util.List;

import webeng.access.DAOFactory;
import webeng.tranferobjects.Message;

public class MessageManager {
	
	public List<Message> getAllMessages() {
		return DAOFactory.getMessageDAO().getAllMessages();
	}
	
	public List<Message> findAllMessages(String userName) {
		return DAOFactory.getMessageDAO().findAllMessages(userName);
	}

	public void addMessage(Message message) {
		DAOFactory.getMessageDAO().addMessage(message);
	}

	public Message getMessage(int id) {
		return DAOFactory.getMessageDAO().getMessage(id);
	}

	public void updateMessage(Message message) {
		DAOFactory.getMessageDAO().updateMessage(message);
	}

	public boolean containsMessage(int id) {
		List<Message> messages = this.getAllMessages();
		boolean messageInList = false;

		for (Message message : messages) {
			if (message.getID() == id) {
				messageInList = true;
			}
		}
		return messageInList;
	}

	public void deleteMessage(Message message) {
		DAOFactory.getMessageDAO().deleteMessage(message);
	}

}
