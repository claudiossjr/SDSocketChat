package br.uff.sdsocketchat.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		try {
            // Set System L&F
			UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }		
		
	}

	public void showMessage(String message) {
		this.chatPanel.setMessagePanel(message);
	}

}
