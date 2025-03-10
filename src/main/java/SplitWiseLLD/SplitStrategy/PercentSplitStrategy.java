package SplitWiseLLD.SplitStrategy;


import java.util.List;
import java.util.stream.Collectors;

public class PercentSplitStrategy implements ISplitStrategy{

    List<Double> percentages;
    public PercentSplitStrategy(List<Double> percentages){
        this.percentages = percentages;
    }

    @Override
    public List<Double> getSplits(Double totalAmount) throws Exception {
        Double sum = percentages.stream().reduce(0.0, Double::sum);
        if(!sum.equals(100.0))
            throw new Exception("percentage sum should be equal to 100");

        return percentages.stream().map(val -> twoDecimalPlace(val * totalAmount/100.0)).collect(Collectors.toList());
    }
    private Double twoDecimalPlace(Double v) {
        return Math.round(v * 100.0)/100.0;
    }
}
