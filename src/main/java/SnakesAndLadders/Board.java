package SnakesAndLadders;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int rows, columns;
    int[][] board;
    int snakeCount;
    int ladderCount;
    Map<Integer, Integer> snakeAndLadder;
    public Board(int rows, int columns, int snakeCount, int ladderCount){
        this.rows = rows;
        this.columns = columns;
        this.board = new int[rows][columns];
        this.snakeCount = snakeCount;
        this.ladderCount = ladderCount;
        snakeAndLadder = new HashMap<>();
        populateSnakeAndLadders();
    }

    private void populateSnakeAndLadders(){
        int snakes = snakeCount;
        int ladders = ladderCount;
        int blockCount = rows * columns;

        while(snakes >=0){

            int first = (int) (Math.random() * blockCount);
            int second = (int) (Math.random() * blockCount);

            if(first > second){
                snakeAndLadder.put(first, second);
                snakes--;
            }
        }

        while(ladders >=0){

            int first = (int) (Math.random() * blockCount);
            int second = (int) (Math.random() * blockCount);

            if(first < second){
                snakeAndLadder.put(first, second);
                ladders--;
            }
        }
    }

    public int nextJump(Player player, int jump){
        int currCell = player.currPosition + jump;
        int newCell = -1;
        newCell = snakeAndLadder.getOrDefault(currCell, currCell);

        if(newCell > currCell){
            System.out.println("Found Ladder");
        }
        if(newCell < currCell)
            System.out.println("Found Snake");
        return newCell;
    }
    public int size(){
        return rows * columns;
    }
}
