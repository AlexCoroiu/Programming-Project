package controller;

import java.util.Scanner;

import model.Board;
import model.Mark;

public class HumanPlayer extends Player{
	 // -- Constructors -----------------------------------------------

    /*@
       requires name != null;
       requires mark == Mark.RED || mark == Mark.YELLOW;
       ensures this.getName() == name;
       ensures this.getMark() == mark;
    */
    /**
     * Creates a new human player object.
     * 
     */
    public HumanPlayer(String name, Mark mark) {
        super(name, mark);
    }

    // -- Commands ---------------------------------------------------

    /*@
       requires board != null;
       ensures board.isField(\result) && board.isEmptyField(\result);

     */
    /**
     * Asks the user to input the field where to place the next mark. This is
     * done using the standard input/output. \
     * 
     * @param board
     *            the game board
     * @return the player's chosen field
     */
    public int[] determineMove(Board board) {
        String prompt = "> " + getName() + " (" + getMark().toString() + ")"
                + ", what is your choice? ";
        int[] choice =Int(readInt(prompt.split(" ")));
        boolean valid = board.isField() && board.isEmptyField(choice);
        while (!valid) {
            System.out.println("ERROR: field " + choice
                    + " is no valid choice.");
            choice = readInt(prompt);
            valid = board.isField(choice) && board.isEmptyField(choice);
        }
        return choice;
    }

    /**
     * Writes a prompt to standard out and tries to read an int value from
     * standard in. This is repeated until an int value is entered.
     * 
     * @param prompt
     *            the question to prompt the user
     * @return the first int value which is entered by the user
     */
    private int readInt(String prompt) {
    	return 0;
    }
}
