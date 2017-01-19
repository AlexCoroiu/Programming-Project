package model.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PlayerConnection {
	private InetAddress addr = null;
    private int port = 0;
    private Socket sock;
    PlayerPeer peer;
	
	public PlayerConnection(String pAddr, int pPort) {
		try {
			addr = InetAddress.getByName(pAddr);
		} catch (UnknownHostException e) {
		    System.out.println("ERROR: host " + pAddr + " unknown");
		}
        port = pPort;     
        try {
            sock = new Socket(addr, port);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on " + addr
                    + " and port " + port);
        }
        try {
            peer = new PlayerPeer(sock);
            Thread streamInputHandler = new Thread(peer);
            streamInputHandler.start();
            peer.handleTerminalInput();
            peer.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public PlayerPeer getPeer() {
		return peer;
	}
}
