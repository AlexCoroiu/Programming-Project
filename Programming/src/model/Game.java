package model;

import model.Player;

public class Game {
	// -- Instance variables -----------------------------------------

    public static final int NUMBER_PLAYERS = 2;

    /*@
       private invariant board != null;
     */
    /**
     * The board.
     */
    private Board board;

    /*@
       private invariant players.length == NUMBER_PLAYERS;
       private invariant (\forall int i; 0 <= i && i < NUMBER_PLAYERS; players[i] != null); 
     */
    /**
     * The 2 players of the game.
     */
    private Player[] players;

    /*@
       private invariant 0 <= current  && current < NUMBER_PLAYERS;
     */
    /**
     * Index of the current player.
     */
    private int current;
    
    // -- Constructors -----------------------------------------------

    /*@
      requires 
     */
    /**
     * Creates a new Game object.
     * 
     * @param playersList
     *            the players
     */
    public Game(Player[] playersList) {
        board = new Board();
        players = playersList;
        current = 0;
    }
    
    // -- Commands ---------------------------------------------------
    
    /**
     * Plays the ConnectFour game.
     * Players can make a move one after the other.
     */
    private void play() {
    	
    }
}
