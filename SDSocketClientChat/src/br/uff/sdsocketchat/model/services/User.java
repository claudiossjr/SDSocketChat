package br.uff.sdsocketchat.model.services;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.uff.sdsocketchat.model.ChatViewModel;

public class User 
{
	private UserSocketReceiver receiver;
	private UserSocketSender   sender;
	private Socket			   server;
	private ChatViewModel	   model;
	public User( ChatViewModel model )
	{
		try {
			this.server				= new Socket ("187.67.225.105",12345);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.model 				= model;
		
		receiver 				= new UserSocketReceiver	(this, server);
		Thread threadReceiver 	= new Thread(receiver);
		threadReceiver.start();
		
		sender					= new UserSocketSender		(this, server);
		Thread threadSender		= new Thread(sender);
		threadSender.start();
	}
	
	public void printMessageInThePanel(String message)
	{
		this.model.showMessage(message);
	}
	
	public void sendMessageToServer ( String message )
	{
		this.sender.sendMessage(message);
	}
}
