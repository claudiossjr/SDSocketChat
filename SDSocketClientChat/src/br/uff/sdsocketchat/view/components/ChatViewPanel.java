package br.uff.sdsocketchat.view.components;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.omg.CORBA.INITIALIZE;

import br.uff.sdsocketchat.controller.ChatViewController;

public class ChatViewPanel extends JPanel
{
	private JTextArea 			messageArea;
	private JButton 			btSend;
	private JTextArea			messageToBeSend;
	
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
								.addComponent(btSend,50,50,50)
						)
				)
				.addContainerGap(10,10)
				.addGroup(layout.createParallelGroup()
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
										.addComponent(messageToBeSend,20,20,20)
										.addComponent(btSend,20,20,20)
								)
						)
						.addGroup(layout.createSequentialGroup()
								
						)
				)
				.addContainerGap(10,10)
		);
		
		this.setLayout(layout);
		
	}

	private void initComponents() 
	{
		this.messageArea 		= new JTextArea();
		this.btSend				= new JButton("Send");
		this.messageToBeSend 	= new JTextArea();
	}
	
	private void initListeners() 
	{
		btSend.addActionListener(controller);
	}
	
	public String getMessageToBeSent()
	{
		String message = messageToBeSend.getText();
		clearMessageToBeSent();
		setMessagePanel(message);
		return message; 
	}

	private void clearMessageToBeSent()
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
	
}
