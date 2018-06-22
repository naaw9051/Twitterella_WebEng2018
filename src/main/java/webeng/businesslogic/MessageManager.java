package webeng.businesslogic;

import java.util.List;

import webeng.access.DAOFactory;
import webeng.tranferobjects.Message;

public class MessageManager {
	
	public List<Message> getAllMessages() {
		return DAOFactory.getMessageDAO().getAllMessages();
	}

	public void addMessage(Message message) {
		DAOFactory.getMessageDAO().addMessage(message);
	}

	public Message getMessage(int id) {
		return DAOFactory.getMessageDAO().getMessage(id);
	}

	public void updateMessage(Message message, int id) {
		DAOFactory.getMessageDAO().updateMessage(message, id);
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
