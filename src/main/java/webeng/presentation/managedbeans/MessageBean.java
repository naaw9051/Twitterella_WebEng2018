package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import webeng.tranferobjects.Message;
import webeng.businesslogic.MessageManager;

@ManagedBean(name = "messageBean")
public class MessageBean implements Serializable{

	Message message = new Message();
	MessageManager messageManager;
	public List<Message> messages = null;
	
	public MessageBean(){ 
		this.messageManager = new MessageManager();
		this.messages = this.messageManager.getAllMessages();
	}
	
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}
	
	public MessageManager getMessageManager() {
		return this.messageManager;
	}
	
	public void setMessage(Message message){
		this.message = message;
	}
	
	public Message getMessage(){
		return this.message;
	}
	
	public void setMessages(List<Message> messages){
		this.messages = messages;
	}
	
	public List<Message> getMessages(){
		return this.messages;
	}
	
	public String save(){
		messageManager.addMessage(message);
		return "";
	}
	
	public String openDetails(Message message) {
		setMessage(message);
		return "MessagePage.xhtml";
	}

	public String reset() {
		this.message = new Message();
		return "";
	}
	
	public void editMessage(String messageText) {
		//TODO only returns a message object with null values
		System.out.println(this.getMessage().getID());

		Message newMessage = new Message();
		newMessage.setMessage(messageText);
		messageManager.updateMessage(newMessage, this.getMessage().getID());
	}
}
