package SnakesAndLadders;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {
    Dice dice;
    Board board;
    Queue<Player> players;
    public SnakeAndLadders(){
        dice = new Dice(1);
        board = new Board(10,10,5,5);
        players = new LinkedList<>();
        initializePlayer();
    }

    private void initializePlayer() {

        Player player1 = new Player(1,"Aditya",0);
        Player player2 = new Player(2, "Ravi", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame(){

        Player winner = null;

        while(winner == null){
            Player currPlayer = getCurrPlayer();

            System.out.println("Current lcation of "+ currPlayer.getName() +" is "+ currPlayer.getCurrPosition());

            int jump = dice.rollDice();

            int nextVal = board.nextJump(currPlayer, jump);
            currPlayer.setCurrPosition(nextVal);

            System.out.println("Next location of "+ currPlayer.getName() +" is "+ nextVal);

            int row = nextVal / board.columns;
            int col = nextVal % board.columns;

            if(nextVal >= board.size()){
                winner = currPlayer;
            }

        }
        System.out.println("Player: "+winner.getName()+" wins, Game Over");
    }

    private Player getCurrPlayer() {
        Player player = players.poll();
        players.add(player);
        return player;
    }
}
