package br.uff.sdsocketchat.main;

import br.uff.sdsocketchat.model.ChatServer;

public class Main {
	public static void main(String[] args) {
		ChatServer server = ChatServer.getInstance();
		server.start();
	}
}
