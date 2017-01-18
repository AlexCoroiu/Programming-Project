package model;

import java.net.Socket;
import java.io.IOException;

public class ServerPeer extends Peer {
	
public ServerPeer(String nameArg, Socket sockArg) throws IOException {
		super(nameArg, sockArg);
	}

	@Override
	public void prot(String s) {
		switch (s) {
		case "":
			break;
		}
	}
}
