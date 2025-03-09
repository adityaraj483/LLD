package SplitWise.SplitStrategy;

import java.util.List;

public interface SplitStrategy {
    List<Double> getSplit(Double amount) throws Exception;
}
