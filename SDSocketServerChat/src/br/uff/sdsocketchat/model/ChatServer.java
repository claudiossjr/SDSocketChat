package br.uff.sdsocketchat.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import br.uff.sdsocketchat.model.services.User;

public class ChatServer 
{
	private final static ChatServer INSTANCE = new ChatServer();
	public static ChatServer getInstance(){ return INSTANCE; }
	
	private ServerSocket serverSocket = null;
	private List<User> userList;
	
	public void start()
	{
		initComponents();
		
		try {
			startService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initComponents() 
	{
		try {
			serverSocket	= new ServerSocket(12345);
			System.out.println("Hey brow, we are listening on port " + serverSocket.getLocalPort());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userList = new ArrayList<>();
	}
	
	private void startService() throws IOException
	{
		while(true)
		{
			Socket userRequest	= serverSocket.accept();
			System.out.println("User register: " + userRequest.getInetAddress().toString());
			User user = new User(userRequest);
			
			this.userList.add(user);
			
		}
	}
	
	public void sendMessageToAllUsers(User sender, String message)
	{
		for(User user : userList)
		{
			if( user != sender )
			{
				user.sendMessage(message);
			}
		}
	}

	public void broadcastMessage(User user,String message) 
	{
		sendMessageToAllUsers(user, message);
	}
	
}
