package SplitWise.Models;

import SplitWise.SplitStrategy.SplitStrategy;

public class Expense {
    Double amount;
    SplitStrategy splitStrategy;
    public Expense(Double amount, SplitStrategy splitStrategy){
        this.amount = amount;
        this.splitStrategy = splitStrategy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }
}
