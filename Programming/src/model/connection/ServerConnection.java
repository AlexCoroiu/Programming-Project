package model.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection {
	private ServerSocket serverSocket;
	private Socket sock;
	private ServerPeer peer;
	
	public ServerConnection(int pPort) {
		try {
			serverSocket = new ServerSocket(pPort);
			System.out.println("Waiting for Connection...");
			sock = serverSocket.accept();
			System.out.println("Connected");
			peer = new ServerPeer(sock);
			new Thread(peer).start();
	    	peer.handleTerminalInput();
	    	serverSocket.close();
	    	peer.shutDown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ServerPeer getPeer() {
		return peer;
	}
}
