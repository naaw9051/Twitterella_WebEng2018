package webeng.presentation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import webeng.tranferobjects.Message;
import webeng.businesslogic.MessageManager;

@ManagedBean(name = "messageBean")
public class MessageBean implements Serializable{

	Message message;
	MessageManager messageManager;
	public List<Message> messages = null;
	
	public MessageBean(){ 
		this.messageManager = new MessageManager();
		this.messages = this.messageManager.getAllMessages();
	}
	
	void setMessage(Message message){
		this.message = message;
	}
	
	public Message getMessage(){
		return this.message;
	}
	
	void setMessages(List<Message> messages){
		this.messages = messages;
	}
	
	public List<Message> getMessages(){
		return this.messages;
	}
	
	public String save(){
		messageManager.addMessage(message);
		return "";
	}
}
