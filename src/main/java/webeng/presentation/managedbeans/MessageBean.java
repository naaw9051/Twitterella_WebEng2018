package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import webeng.tranferobjects.Message;
import webeng.businesslogic.MessageManager;

@ManagedBean(name = "messageBean")
public class MessageBean implements Serializable{

	Message message = new Message();
	MessageManager messageManager;
	public List<Message> messages = null;
	boolean canEdit = false;
	
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
	
	public boolean isCanEdit() {
		return this.canEdit;
	}
	
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
	public String save(){
		messageManager.addMessage(message);
		return "";
	}
	
	public String openDetails(Message message) {
		setMessage(message);
		return "MessagePage.xhtml";
	}

	public String delete() {
		//TODO
		System.out.println("delete()/////////////////////////////////////////////");
		messageManager.deleteMessage(message);
		return "";
	}
	
	public String reset() {
		this.message = new Message();
		return "";
	}
	
	public String editMessage(){
		//TODO
		System.out.println("editMessage()/////////////////////////////////////////////");
		System.out.println(message.getID());
		System.out.println(message.getMessage());
		System.out.println(message.getLikes());
		System.out.println(message.getUserName());
		messageManager.updateMessage(message);
		return "";
	}
	
	public void editListener(AjaxBehaviorEvent e) {
		System.out.println("Before: " + this.canEdit);
		canEdit = !canEdit;
		System.out.println("After: " + this.canEdit);
	}
}
