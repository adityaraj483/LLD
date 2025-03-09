package DecoratorPattern.PizzaShop.BasePizza;

public class CrispyBread implements IBasePizza{
    @Override
    public int cost() {
        return 20;
    }
}
