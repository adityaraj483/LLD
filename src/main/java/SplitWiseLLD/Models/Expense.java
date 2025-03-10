package SplitWiseLLD.Models;

import SplitWiseLLD.SplitStrategy.ISplitStrategy;

public class Expense {
    Double amount;
    ISplitStrategy splitStrategy;
    public Expense(Double amount, ISplitStrategy splitStrategy){
        this.amount = amount;
        this.splitStrategy = splitStrategy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ISplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(ISplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }
}
