package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Peer implements Runnable {
	public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected PrintWriter out;

    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    	this.out = new PrintWriter(sock.getOutputStream(),true);
    }

    public void run() {
    	while(true) {
    		try {
    			prot(in.readLine());
    		} catch (IOException ex) {
    			
    		}
    	}
    }
    
    public void prot(String s) {
    	
    }

    public void sendMessage(String message) {
			out.println(message);
			out.flush();
    }

    public void shutDown() {
    	try{
    		in.close();
    		out.close();
    		sock.close();
    	}catch(IOException ex) {
    		
    	}
    }
}
