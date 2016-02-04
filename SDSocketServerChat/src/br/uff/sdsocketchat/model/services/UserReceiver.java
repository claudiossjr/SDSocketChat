package br.uff.sdsocketchat.model.services;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class UserReceiver implements Runnable
{
	private Socket socket;
	private User user;
	
	public UserReceiver ( User user, Socket socket )
	{
		this.socket = socket;
		this.user 	= user;
	}

	@Override
	public void run() 
	{
	
		try (Scanner inputStream = new Scanner(this.socket.getInputStream())){
			
			while(inputStream.hasNext())
			{
				String message = inputStream.nextLine();
				
				if(message.indexOf("Login") >= 0)
				{
					String temp = message.split(" ")[1];
					message		= "Usurário >> " + temp + " << acabou de entrar no chat";
				}
				
				System.out.println("Receiving message from: " + this.socket.getInetAddress().toString() + " Message: " + message);
				this.user.broadcastMessage(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
