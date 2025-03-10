package SplitWiseLLD.SplitStrategy;


import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements ISplitStrategy{
    int noOfUsers;
    public EqualSplitStrategy(int noOfUsers){
        this.noOfUsers = noOfUsers;
    }
    @Override
    public List<Double> getSplits(Double totalAmount) {
       List<Double> splits = new ArrayList<>();
       for(int i=0;i<noOfUsers;i++){
           splits.add(twoDecimalPlace(totalAmount/noOfUsers));
       }
       return splits;
    }

    private Double twoDecimalPlace(Double v) {
        return Math.round(v * 100.0)/100.0;
    }
}
