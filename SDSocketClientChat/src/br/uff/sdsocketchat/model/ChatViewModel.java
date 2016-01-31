package br.uff.sdsocketchat.model;

import br.uff.sdsocketchat.controller.ChatViewController;
import br.uff.sdsocketchat.model.services.User;

public class ChatViewModel 
{
	private User user;
	
	public ChatViewController controller;
	
	public ChatViewModel( ChatViewController controller )
	{
		this.controller = controller;
		this.user		= new User(this);
	}
	
	public void sendMessage(String message) 
	{
		this.user.sendMessageToServer(message);
	}
	
	public void showMessage ( String message )
	{
		controller.showMessage( message );
	}

}
