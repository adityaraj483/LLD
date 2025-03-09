package SnakesAndLadders;

public class Dice {
    int numberOfDice;
    public Dice(int n){
        this.numberOfDice = n;
    }

    public int rollDice(){
        int dice = numberOfDice;
        int jump =0;
        while(dice > 0){
            jump += (int) (Math.random() * 6) + 1;
            dice--;
        }
        return  jump;
    }
}
