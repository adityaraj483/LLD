package TickTakToe;

public class Player {
    String name;
    PieceType piece;
    public Player(String name, PieceType piece){
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceType getPiece() {
        return piece;
    }

    public void setPiece(PieceType piece) {
        this.piece = piece;
    }
}
