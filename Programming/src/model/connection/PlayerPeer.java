package model.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerPeer implements Runnable {
	protected Socket sock;
    protected BufferedReader in;
    protected PrintWriter out;
	private String input = "";
	
	public PlayerPeer(Socket sockArg) throws IOException {
		sock = sockArg;
    	in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    	out = new PrintWriter(sock.getOutputStream(),true);
	}

	public void run() {
		while(true) {
			try {
				input = in.readLine();
				switch (input) {
				case "":
					break;
				}
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}
	
	public void handleTerminalInput() {
		
	}

	public void shutDown() {
    	try{
    		in.close();
    		out.close();
    		sock.close();
    	} catch (IOException e){
    		e.getStackTrace();
    	}
    }
}
