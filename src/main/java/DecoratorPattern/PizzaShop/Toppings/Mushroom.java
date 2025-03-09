package DecoratorPattern.PizzaShop.Toppings;

import DecoratorPattern.PizzaShop.BasePizza.IBasePizza;

public class Mushroom extends Topping{
    public Mushroom(IBasePizza pizza){
        super(pizza);
    }
    @Override
    public int cost() {
        return super.cost() + 20;
    }
}
