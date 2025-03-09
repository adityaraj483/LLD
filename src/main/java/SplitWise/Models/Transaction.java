package SplitWise.Models;
import java.util.*;

public class Transaction {
    User paidBy;
    List<User> paidFor;
    Expense expense;
    Map<User, Double> splits;

    public Transaction(User paidBy, List<User> paidFor, Expense exp){
        this.paidBy = paidBy;
        this.paidFor = paidFor;
        this.expense = exp;
        this.splits = new HashMap<>();
    }

    public void populateSplits() throws Exception {
        List<Double> splitAmount = expense.getSplitStrategy().getSplit(expense.getAmount());
        for(int i=0;i<paidFor.size();i++){
            splits.put(paidFor.get(i), splitAmount.get(i));
        }
    }

    public Map<User, Double> getSplits(){
        return splits;
    }
}
