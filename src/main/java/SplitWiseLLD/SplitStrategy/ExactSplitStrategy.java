package SplitWiseLLD.SplitStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ExactSplitStrategy implements ISplitStrategy{
    List<Double> amount;
    public ExactSplitStrategy(List<Double> amount){
        this.amount = amount;
    }
    @Override
    public List<Double> getSplits(Double totalAmount) throws Exception {
        Double sum = amount.stream().reduce(0.0, Double::sum);
        if(!sum.equals(totalAmount))
            throw new Exception("sum values should be equal to total sum");

        return amount.stream().map(this::twoDecimalPlace).collect(Collectors.toList());
    }
    private Double twoDecimalPlace(Double v) {
        return Math.round(v * 100.0)/100.0;
    }
}
