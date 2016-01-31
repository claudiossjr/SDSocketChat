package br.uff.sdsocketchat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.uff.sdsocketchat.model.ChatViewModel;
import br.uff.sdsocketchat.view.ChatView;
import br.uff.sdsocketchat.view.components.ChatViewPanel;

public class ChatViewController implements ActionListener
{

	private ChatView 		view;
	private ChatViewModel 	model;
	
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
		String message			= panel.getMessageToBeSent();
		
		model.sendMessage(message);
		
	}

	public void showMessage(String message) 
	{
		view.showMessage (message);
	}

}
