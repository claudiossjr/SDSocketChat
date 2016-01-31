package br.uff.sdsocketchat.model.services;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import br.uff.sdsocketchat.model.ChatServer;

public class UserSender implements Runnable 
{
	private PrintStream userStream = null;
	
	public UserSender ( User user, Socket socket )
	{
		
		try {
			this.userStream = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		
	}

	public void sendMessage(String message) 
	{
		if(userStream != null)
		{
			this.userStream.println(message);
		}
	}

}
