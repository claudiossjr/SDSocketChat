package br.uff.sdsocketchat.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.uff.sdsocketchat.controller.ChatViewController;
import br.uff.sdsocketchat.view.components.ChatViewPanel;

public class ChatView 
{
	private ChatViewPanel		chatPanel;
	
	public ChatView( ChatViewController controller )
	{
		this.chatPanel	= new ChatViewPanel( controller );
		
		JFrame frame 	= new JFrame(); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.add(this.chatPanel);
		frame.setVisible(true);
		
	}

	public void showMessage(String message) {
		this.chatPanel.setMessagePanel(message);
	}

}
