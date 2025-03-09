package TickTakToe;

public class Board {
    Character[][] board;
    int size;
    public Board(int n){
        board = new Character[n][n];
        this.size = n;
        populateBoard();
    }

    private void populateBoard() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = '-';
            }
        }
    }

    public boolean isBoardEmptyAt(int row, int col){
        return board[row-1][col-1] == '-';
    }

    public void putPieceAt(int row, int col, PieceType piece){
        board[row-1][col-1] = piece.getPiece();
    }

    public void printBoard(){
        for(Character[] row : board){
            for(Character ch : row)
                System.out.print(ch+" ");
            System.out.println();
        }
    }

    public Character getBoardCharacter(int row, int col){
        return board[row][col];
    }


}
