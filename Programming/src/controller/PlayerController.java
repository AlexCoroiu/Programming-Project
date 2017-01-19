package controller;

import model.HumanPlayer;
import model.Mark;
import model.connection.PlayerConnection;
import model.connection.PlayerPeer;
import view.PlayerTui;

public class PlayerController implements Runnable {
	PlayerTui tui;
	HumanPlayer player;
	PlayerConnection connection;
	PlayerPeer peer;	
	
	public static void main(String[] args) {
		new PlayerController();
	}
	
	public PlayerController() {
		tui = new PlayerTui();
		player = new HumanPlayer(tui.name(), Mark.X);
		connect();
		
	}
	
	public void connect() {
		connection = new PlayerConnection(tui.addr(), tui.port());
		peer = connection.getPeer();
	}
	
	public void run() {
    	while(true){
    		switch (tui.readString("")) {
    		case "":
    			break;
    		}
    	}
    }
}
