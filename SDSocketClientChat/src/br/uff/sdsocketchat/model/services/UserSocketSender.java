package br.uff.sdsocketchat.model.services;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class UserSocketSender implements Runnable
{

	private User user;
	private Socket server;
	private PrintStream outputServer;
	
	public UserSocketSender(User user, Socket server) 
	{
		this.user 			= user;
		this.server 		= server;
		try {
			this.outputServer 	= new PrintStream(server.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void run() 
	{
		
	}
	
	public void sendMessage(String message)
	{
		this.outputServer.println(message);
	}

}
