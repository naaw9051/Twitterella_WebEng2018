package webeng.access;

import java.util.List;
import webeng.tranferobjects.Message;

public interface MessageDAO {
	public List<Message> getAllMessages();
	public List<Message> findAllMessages(String userName);
	public void addMessage(Message m);
	public Message getMessage(int id);
	public void updateMessage(Message m, int id);
	public void deleteMessage(Message m);
}
