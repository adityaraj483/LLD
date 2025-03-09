package TickTakToe;

public enum PieceType {
    X('X'),
    O('O');

    final Character piece;
    PieceType(Character piece){
        this.piece = piece;
    }
    public Character getPiece(){
        return this.piece;
    }
}
