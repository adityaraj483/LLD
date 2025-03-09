package SplitWise.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy{
    int noOfUsers;
    List<Double> amounts;
    public EqualSplit(int noOfUsers){
        this.noOfUsers = noOfUsers;
        amounts = new ArrayList<>();
    }
    @Override
    public List<Double> getSplit(Double amount) {
         for(int i=0;i<noOfUsers;i++){
             amounts.add(twoDecimalPlace(amount/noOfUsers));
         }
         return  amounts;
    }
    private Double twoDecimalPlace(double amount) {
        return Math.round(amount * 100.0)/100.0;
    }
}
