package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import webeng.tranferobjects.Message;
import webeng.businesslogic.MessageManager;

@ManagedBean(name = "messageBean")
@SessionScoped
public class MessageBean implements Serializable{

	Message message;
	MessageManager messageManager;
	public List<Message> messages;
	boolean canEdit;
	
	public MessageBean(){ 
		this.message = new Message();
		this.messageManager = new MessageManager();
		this.messages = this.messageManager.getAllMessages();
		this.canEdit = false;
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
	
	public boolean isOwnPost(Message message) {
		return (UserBean.loginUser != null && message.getUserName().equals(UserBean.loginUser.getName()));
	}
	
	public String save(){
		message.setID(messageManager.getLargestID() + 1);
		message.setUserName(UserBean.loginUser.getName());
		message.setLikes(0);
		messageManager.addMessage(message);
		setMessages(this.messageManager.getAllMessages());
		
		return "HomePage.xhtml";
	}
	
	public String openDetails(Message message) {
		setMessage(message);
		return "MessagePage.xhtml";
	}
	
	public String likePost(Message message) {
		setMessage(message);
		message.setLikes(message.getLikes() +1);
		return editMessage();
	}

	public String delete() {
		messageManager.deleteMessage(message);
		return "ProfilePage.xhtml";
	}
	
	public String reset() {
		this.message = new Message();
		return "";
	}
	
	public String editMessage(){
		messageManager.updateMessage(message);
		return "MessagePage.xhtml";
	}
	
	public void editListener(AjaxBehaviorEvent e) {
		canEdit = !canEdit;
	}
}
