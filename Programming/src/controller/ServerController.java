package controller;

import view.ServerTui;

public class ServerController {
	private static final String USAGE
    = "usage: " + ServerController.class.getName() + " <name> <port>";
	
	public static void main(String[] args) {
		ServerTui tui = new ServerTui();
		
		if(args.length!=2){
    		System.out.println(USAGE);
    		System.exit(0);
    	}
		tui.begin();
	}
}
