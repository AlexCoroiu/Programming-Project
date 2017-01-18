package model;

import java.util.Arrays;

public class Board {
	public static final int DIM = 4;
	
	//@ private invariant fields.length == DIM*DIM;
    /*@ invariant (\forall int x; 0 <= x & x < DIM*DIM;
        getField(x) == Mark.EMPTY || getField(x) == Mark.red || getField(x) == Mark.OO); */
    private Mark[][][] fields;
	
    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     */
    //@ ensures (\forall int x; 0 <= x & x < DIM * DIM; this.getField(x) == Mark.EMPTY);
    public Board(){
    	this.fields= new Mark[DIM][DIM][DIM];
    	Arrays.fill(fields,Mark.EMPTY);
	}
    
    /**
     * @return true if 0 <= x < DIM && 0 <= y < DIM && 0<= z < DIM
     */
    //@ ensures \result == (0 <= x && x < DIM && 0 <= y && y < DIM && 0 <= z && z < DIM);
    /*@pure*/
    public boolean isField(int x, int y, int z) {
    	return x >= 0 && x < DIM && y >= 0 && y < DIM && y >= 0 && y < DIM;
    }
    
    /**
     * Returns the content of the field referred to by fields[x][y][z].
     *
     * @param x
     *            the x of the field
     * @param y
     *            the y of the field
     * @param z
     *            the z of the field
     * @return the mark on the field
     */
    //@ requires this.isField(x,y,z);
    //@ ensures \result == Mark.EMPTY || \result == Mark.RED || \result == Mark.YELLOW;
    /*@pure*/
    public Mark getField(int x, int y,int z) {
    	assert this.isField(x,y,z);
    	return fields[x][y][z];
    }

    /**
     * Returns true if the field referred to by fields[x][y][z] is empty.
     *
     * @param x
     *            the x of the field
     * @param y
     *            the  y of the field
     * @param z
     *            the z of the field
     * @return true if the field is empty
     */
    //@ requires this.isField(x,y,z);
    //@ ensures \result == (this.getField(x,y,z) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int x, int y,int z) {
    	assert this.isField(x,y,z);
    	return fields[x][y][z] == Mark.EMPTY;
    }
    
    /**
     * Tests if the whole board is full.
     *
     * @return true if all fields are occupied
     */
    //@ ensures \result == (\forall int x; x <= 0 & x < DIM && int y; y <= 0 & y < DIM; && int z; z <= 0 & z < DIM; this.getField(x,y,z) != Mark.EMPTY);
    /*@pure*/
    public boolean isFull() {
    	for (int x=0;x<DIM;x++){
    		for (int y=0;y<DIM;y++){
    			for (int z=0;z<DIM;z++){
    				if(fields[x][y][z]==Mark.EMPTY)
    	    			return false;
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     *
     * @return true if the game is over
     */
    //@ ensures \result == this.isFull() || this.hasWinner();
    /*@pure*/
    public boolean gameOver() {
    	return this.isFull() || this.hasWinner();
    }
    
    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a row controlled by m
     */
    /*@ pure */
    public boolean hasRow(Mark m) {
    	return true;
    }
    
    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a column controlled by m
     */
    /*@ pure */
    public boolean hasColumn(Mark m) {
    	return true;
    }
    
    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a diagonal controlled by m
     */
    /*@ pure */
    public boolean hasDiagonal(Mark m) {
    	return true;
    }
    
    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     *
     * @param m
     *            the mark of interest
     * @return true if the mark has won
     */
    //@requires m == Mark.RED | m == Mark.YELLOW;
    //@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    /*@ pure */
    public boolean isWinner(Mark m) {
    	assert m==Mark.RED || m==Mark.YELLOW;
    	return hasRow(m) || hasColumn(m) || hasDiagonal(m);
    }
    
    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     *
     * @return true if the student has a winner.
     */
    //@ ensures \result == isWinner(Mark.RED) | \result == isWinner(Mark.YELLOW);
    /*@pure*/
    public boolean hasWinner() {
    	return isWinner(Mark.RED) || isWinner(Mark.YELLOW);
    }
    
    /**
     * Sets the content of fields[x][y][z] to the mark m.
     *
      * @param x
     *            the x of the field
     * @param y
     *            the  y of the field
     * @param z
     *            the z of the field
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(x);
    //@ ensures this.getField(x) == m;
    public void setField(int x,int y, int z, Mark m) {
    	assert fields[x][y][z]!=null;
    	fields[x][y][z]=m;
    }

}
