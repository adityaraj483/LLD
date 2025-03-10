package SplitWiseLLD.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {
    User paidBy;
    List<User> paidFor;
    Expense expense;
    Map<User, Double> splits;

    public Transaction(User paidBy, List<User> paidFor, Expense expense) throws Exception {
        this.paidBy = paidBy;
        this.paidFor = paidFor;
        this.expense = expense;
        splits = new HashMap<>();
        populateSplits();
    }

    public void populateSplits() throws Exception {
        List<Double> amounts = expense.splitStrategy.getSplits(expense.amount);

        for(int i=0;i<amounts.size();i++) {
            splits.put(paidFor.get(i), amounts.get(i));
        }
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getPaidFor() {
        return paidFor;
    }

    public void setPaidFor(List<User> paidFor) {
        this.paidFor = paidFor;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Map<User, Double> getSplits() {
        return splits;
    }

    public void setSplits(Map<User, Double> splits) {
        this.splits = splits;
    }
}
