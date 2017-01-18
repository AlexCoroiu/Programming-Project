package model;

public enum Mark {

    EMPTY,RED,YELLOW;
	
	/*@
    ensures this == Mark.RED ==> \result == Mark.YELLOW;
    ensures this == Mark.YELLOW ==> \result == Mark.RED;
    ensures this == Mark.EMPTY ==> \result == Mark.EMPTY;
  */
 /**
  * Returns the other mark.
  * 
  * @return the other mark is this mark is not EMPTY or EMPTY
  */

    public Mark other() {
        if (this == RED) {
            return YELLOW;
        } else if (this == YELLOW) {
            return RED;
        } else {
            return EMPTY;
        }
    }
}
