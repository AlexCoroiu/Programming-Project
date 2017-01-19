package view;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ServerTui implements Tui {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss : ");
	
	public ServerTui() {	
	}
	
	public String time() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return sdf.format(timestamp);
	}
	
	public void begin() {
		System.out.println(time() + "Server started");
	}
	
	public void playerConnected(String name) {
		System.out.println(time() + "Player " + name + " connected to the Server");
	}
	
	public void playerDisconnected(String name) {
		System.out.println(time() + "Player " + name + " disconnected from the Server");
	}
}
