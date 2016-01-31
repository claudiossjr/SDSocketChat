package br.uff.sdsocketchat.model.services;

import java.net.Socket;

import br.uff.sdsocketchat.model.ChatServer;

public class User 
{
	private UserSender sender;
	private UserReceiver receiver;
	private Socket userSocket;
	private ChatServer server;
	
	public User ( Socket socket )
	{
		this.userSocket 		= socket;
		this.server 			= ChatServer.getInstance();
		initComponenets();
	}

	private void initComponenets() 
	{
		this.sender 			= new UserSender(this, this.userSocket);
		Thread threadSender 	= new Thread (this.sender);
		threadSender.start();
		this.receiver			= new UserReceiver(this,this.userSocket);
		Thread threadReceiver 	= new Thread(this.receiver);
		threadReceiver.start();
	}

	public void sendMessage(String message) 
	{
		this.sender.sendMessage(message);
	}

	public void broadcastMessage(String message) 
	{
		this.server.broadcastMessage(this,message);
	}
}
