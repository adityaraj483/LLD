package SplitWise.SplitStrategy;

import java.util.List;
import java.util.stream.Collectors;


public class PercentSplit implements SplitStrategy{
    List<Double> percentages;
    public PercentSplit(List<Double> percentages){
        this.percentages = percentages;
    }
    @Override
    public List<Double> getSplit(Double amount) throws Exception {
        Double sum = 0.0;
        for(Double val : percentages){
            sum += val;
        }

        if(!sum.equals(100.0))
            throw new Exception("Sum of percentage should be 100");
        return percentages.stream().map(t -> twoDecimalPlace(t * amount/100.0)).collect(Collectors.toList());

    }
    private Double twoDecimalPlace(double amount) {
        return Math.round(amount * 100.0)/100.0;
    }
}
