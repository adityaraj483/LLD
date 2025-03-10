package SplitWiseLLD.SplitStrategy;

import java.util.List;

public interface ISplitStrategy {
    List<Double> getSplits(Double totalAmount) throws Exception;
}
