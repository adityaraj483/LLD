package DecoratorPattern.PizzaShop.BasePizza;

import java.util.stream.BaseStream;

public class PlainBread implements IBasePizza {
    @Override
    public int cost() {
        return 10;
    }
}
