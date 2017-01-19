package model;

public enum Mark {

    EMPTY,X,O;
	
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
        if (this == X) {
            return O;
        } else if (this == O) {
            return X;
        } else {
            return EMPTY;
        }
    }
}
