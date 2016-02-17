package br.uff.sdsocketchat.view.components;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.INITIALIZE;

import br.uff.sdsocketchat.controller.ChatViewController;

public class ChatViewPanel extends JPanel
{
	private JTextArea 			messageArea;
	private JButton 			btSend;
	private JTextArea			messageToBeSend;
	
	private JTextField			tfUserName;
	private JButton				btLogin;
	
	private ChatViewController controller;
	
	public ChatViewPanel ( ChatViewController controller )
	{
		this.controller = controller;
		initComponents();
		
		initLayout ();
		initListeners();
	}
	
	private void initLayout() 
	{
		GroupLayout layout = new GroupLayout(this);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addContainerGap(10,10)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGroup(layout.createSequentialGroup()
								.addComponent(messageArea,680,680,680)
						)
						.addGroup(layout.createSequentialGroup()
								.addComponent(messageToBeSend,620,620,620)
								.addContainerGap(10,10)
								.addComponent(btSend)
						)
				)
				.addContainerGap(10,10)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addGap(10)
						.addComponent(tfUserName)
						.addGap(10)
						.addComponent(btLogin)
				)
				.addContainerGap(10,10)
		);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addContainerGap(10,10)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup()
										.addComponent(messageArea,540,540,540)
								)
								.addContainerGap(10,10)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(messageToBeSend)
										.addComponent(btSend)
								)
						)
						.addGroup(layout.createSequentialGroup()
								.addComponent(tfUserName)
								.addContainerGap()
								.addComponent(btLogin)
						)
				)
				.addContainerGap(10,10)
		);
		
		this.setLayout(layout);
		
	}

	private void initComponents() 
	{
		this.messageArea 		= new JTextArea();
		this.messageArea.setEditable(false);
		this.btSend				= new JButton("Send");
		this.btSend.setName("Send");
		this.messageToBeSend 	= new JTextArea();
		
		this.tfUserName			= new JTextField();
		this.btLogin			= new JButton("Login");
		this.btLogin.setName("Login");
		
		LogOut();
	}
	
	public void LogIn()
	{
		this.btSend.setEnabled(true);
		this.messageToBeSend.setEnabled(true);
		
		this.tfUserName.setEnabled(false);
		this.btLogin.setEnabled(false);
	}
	
	public void LogOut()
	{
		this.btSend.setEnabled(false);
		this.messageToBeSend.setEnabled(false);
		
		this.tfUserName.setEnabled(true);
		this.btLogin.setEnabled(true);
	}
	
	private void initListeners() 
	{
		btSend.addActionListener(controller);
		btLogin.addActionListener(controller);
	}
	
	public String getMessageToBeSent()
	{
		String message = messageToBeSend.getText();
		
		return message; 
	}

	public void clearMessageToBeSent()
	{
		setMessageToBeSent("");
	}
	
	public void setMessageToBeSent( String message )
	{
		messageToBeSend.setText(message);
	}
	
	public void setMessagePanel (String message) 
	{
		String newMessage = (messageArea.getText().length() > 0)? messageArea.getText() + "\n" + message : message;
		messageArea.setText(newMessage);
	}
	
	public String getUserName()
	{
		return this.tfUserName.getText();
	}
	
}
