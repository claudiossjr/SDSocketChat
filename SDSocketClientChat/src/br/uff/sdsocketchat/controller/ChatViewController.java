package br.uff.sdsocketchat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.uff.sdsocketchat.model.ChatViewModel;
import br.uff.sdsocketchat.view.ChatView;
import br.uff.sdsocketchat.view.components.ChatViewPanel;

public class ChatViewController implements ActionListener
{

	private ChatView 		view;
	private ChatViewModel 	model;
	private String 			userName;
	
	public ChatViewController (  ) 
	{
		this.model 		= new ChatViewModel(this);
		this.view 		= new ChatView(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton button 			= (JButton)e.getSource();
		ChatViewPanel panel 	= (ChatViewPanel)button.getParent();
		
		if(button.getName().equalsIgnoreCase("Send"))
		{
			String message		= panel.getMessageToBeSent();
			
			message 			= this.userName + ">> " + message;
			
			panel.clearMessageToBeSent();
			panel.setMessagePanel(message);
			model.sendMessage(message);
		}
		else if(button.getName().equalsIgnoreCase("Login"))
		{
			String userName = panel.getUserName();
			this.userName	= userName.trim();
			if(this.userName != null && !this.userName.isEmpty())
			{
				String messageToAnnounceLogin = "Login " + userName;
				panel.LogIn();
				model.sendMessage(messageToAnnounceLogin);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Username can not be empty.");
			}
		}
		
		
	}

	public void showMessage(String message) 
	{
		view.showMessage (message);
	}

}
