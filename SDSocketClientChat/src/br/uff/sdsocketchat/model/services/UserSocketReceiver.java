package br.uff.sdsocketchat.model.services;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class UserSocketReceiver implements Runnable{

	private User user;
	private Socket server;
	
	public UserSocketReceiver(User user, Socket server) 
	{
		this.user 		= user;
		this.server 	= server;
	}

	@Override
	public void run() 
	{
		
		try (Scanner serverInput = new Scanner(server.getInputStream())){
		
			while( serverInput.hasNext() )
			{
				this.user.printMessageInThePanel(serverInput.nextLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
