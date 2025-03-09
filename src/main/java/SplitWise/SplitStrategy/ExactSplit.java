package SplitWise.SplitStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ExactSplit implements SplitStrategy{
    List<Double> exactAmount;
    public ExactSplit(List<Double> exactAmount){
        this.exactAmount = exactAmount;
    }
    @Override
    public List<Double> getSplit(Double amount) throws Exception {
        Double sum = 0.0;
        for(Double val : exactAmount){
            sum += val;
        }
        if(!sum.equals(amount))
            throw new Exception("Sum of money should be equal to total amount");
        return exactAmount.stream().map(val -> twoDecimalPlace(val)).collect(Collectors.toList());
    }

    private Double twoDecimalPlace(double amount) {
        return Math.round(amount * 100.0)/100.0;
    }
}
