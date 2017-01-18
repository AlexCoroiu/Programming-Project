package connection;

import java.net.Socket;
import java.io.IOException;

public class PlayerPeer extends Peer {
	
public PlayerPeer(String nameArg, Socket sockArg) throws IOException {
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
