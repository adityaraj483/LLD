package ATMLLD;


import ATMLLD.State.State;

public class AtmMachine {
    int twoThousandRupeesCount;
    int oneThousandRupeesCount;
    int fiveHundredRupeesCount;
    State state;
    int amount;

    public AtmMachine(State state, int amount){
        this.state = state;
        this.amount = amount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTwoThousandRupeesCount() {
        return twoThousandRupeesCount;
    }

    public void setTwoThousandRupeesCount(int twoThousandRupeesCount) {
        this.twoThousandRupeesCount = twoThousandRupeesCount;
    }

    public int getOneThousandRupeesCount() {
        return oneThousandRupeesCount;
    }

    public void setOneThousandRupeesCount(int oneThousandRupeesCount) {
        this.oneThousandRupeesCount = oneThousandRupeesCount;
    }

    public int getFiveHundredRupeesCount() {
        return fiveHundredRupeesCount;
    }

    public void setFiveHundredRupeesCount(int fiveHundredRupeesCount) {
        this.fiveHundredRupeesCount = fiveHundredRupeesCount;
    }
}
