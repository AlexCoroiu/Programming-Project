package model;

public enum Mark {

    EMPTY, X, O;

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
