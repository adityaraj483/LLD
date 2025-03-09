package TickTakToe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static TickTakToe.Command.exit;

public class Game {
    Player winner = null;
    Board board;
    Queue<Player> players;
    int size ;
    public Game(int size){
        board = new Board(size);
        players = new LinkedList<>();
        this.size = size;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void startGame(){


        Scanner scn = new Scanner(System.in);
        String player1 = scn.nextLine();
        String player2 = scn.nextLine();
        addPlayers(player1, player2);

        board.printBoard();
        int count = 0;


        while(scn.hasNext()){
            String cmd = scn.nextLine();

            switch (cmd){
                case "exit" :
                    System.exit(0);
                default:
                    String[] index = cmd.split(" ");
                    int row = Integer.parseInt(index[0]);
                    int col = Integer.parseInt(index[1]);
                    count += processNextMove(row, col) ? 1 : 0;
            }
            if(count == size * size && winner == null) {
                System.out.println("Tie");
                break;
            }
        }
        if(winner == null){
            System.out.println("Game Over");
        }
    }

    private boolean processNextMove(int row, int col) {
        if (!board.isBoardEmptyAt(row, col)){
            System.out.println("Invalid Move");
            return false;
        }else{

            Player player = players.poll();
            board.putPieceAt(row, col, player.getPiece());
            players.add(player);
            board.printBoard();
            checkIsPlayerWins(row, col, player);
            return true;
        }

    }

    private void checkIsPlayerWins(int row, int col, Player player) {
        int i;
        for(i=0;i<board.size;i++){
            if( !(player.getPiece().getPiece() == board.getBoardCharacter(i, col-1)))
                break;
        }

        if( i== 3){
            winner = player;
            System.out.println(player.getName() +" won the game");
            return;
        }
        for(i=0;i<board.size;i++){
            if( !(player.getPiece().getPiece() == board.getBoardCharacter(row-1, i)))
                break;
        }

        if( i == 3){
            winner = player;
            System.out.println(player.getName() +" won the game");
            return;
        }

        if( row != col)
            return;

        for( i=0;i<board.size;i++){
            if( !(player.getPiece().getPiece() == board.getBoardCharacter(i, i)))
                break;
        }

        if( i == 3){
            winner = player;
            System.out.println(player.getName() +" won the game");
            return;
        }
    }

    private void addPlayers(String player1, String player2){
        String[] p1 = player1.split(" ");
        String name = p1[1];
        String piece = p1[0];
        Player player = new Player(name, PieceType.valueOf(piece));
        addPlayer(player);

        String[] p2 = player2.split(" ");
        name = p2[1];
        piece = p2[0];
        player = new Player(name, PieceType.valueOf(piece));
        addPlayer(player);
    }

}
