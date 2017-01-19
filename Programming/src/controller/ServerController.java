package controller;

import model.connection.ServerConnection;
import model.connection.ServerPeer;
import view.ServerTui;

public class ServerController {
	private ServerTui tui;
	ServerConnection connection;
	ServerPeer peer;
	
	public static void main(String[] args) {
		new ServerController();
	}
	
	public ServerController() {
		tui = new ServerTui();
		openServer();
	}
	
	public void openServer() {
		connection = new ServerConnection(tui.port());
		peer = connection.getPeer();
	}
}
