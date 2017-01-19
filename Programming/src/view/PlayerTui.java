package view;

import java.io.IOException;
import java.util.Observable;

import model.Board;
import model.Mark;

public class PlayerTui implements Tui {
	private static final String[] NUMBERING = {" 00 | 01 | 02 | 03 ", "----+----+----+----",
	        " 10 | 11 | 12 | 13 ", "----+----+----+----", " 20 | 21 | 22 | 23 ",
	        "----+----+----+----", " 30 | 31 | 32 | 33 "};
	private static final String LINE = NUMBERING[1];
	private static final String DELIM = "     ";
	private Mark[][][] fields;
	
	public PlayerTui() {
    	this.fields= new Mark[Board.DIM][Board.DIM][Board.DIM];
    	for (int x = 0; x < Board.DIM; x++) {
    		for (int y = 0; y < Board.DIM; y++) {
    			for (int z = 0; z < Board.DIM; z++) {
    				this.fields[x][y][z]= Mark.EMPTY;
    			}
    		}
    	}
    }
	
	public String name() {
		return readString("Name: ");
	}
	
	public String addr() {
		return readString("Server address: ");
	}
	
	public void connected(String address, String port) {
		System.out.println("Connected to " + address + " " + port);
	}
	
	public void gameStart(String name) {
		System.out.println("You play against " + name);
	}
	
	public void addMark(int x, int y, Mark mark ) {
		int z = 0;
		while (this.fields[x][y][z] != Mark.EMPTY) {
			z++;
		}
		this.fields[x][y][z] = mark;
	}
	
	public String toString() {
        String s = "";
        for (int x = 0; x < Board.DIM; x++) {
            String row = "";
            for (int y = 0; y < Board.DIM; y++) {
            	String pillar = "";
            	for (int z = 0; z < Board.DIM; z++) {
		        	if (this.fields[x][y][z] == Mark.EMPTY) {
		        		pillar = pillar + "_";
		        	} else {
		        		pillar = pillar + this.fields[x][y][z];
		        	}
            	}
	            if (y < Board.DIM - 1) {
	                row = row + pillar + "|";
	            } else {
	            	row = row + pillar;
	            }
            }
            s = s + row + DELIM + NUMBERING[x * 2];
            if (x < Board.DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[x * 2 + 1] + "\n";
            }
        }
        return s;
    }
}
