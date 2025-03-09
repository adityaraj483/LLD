package DecoratorPattern.PizzaShop.Toppings;

import DecoratorPattern.PizzaShop.BasePizza.IBasePizza;

public class Topping implements IBasePizza {
    IBasePizza basePizza;
    Topping(IBasePizza pizza){
        this.basePizza = pizza;
    }
    @Override
    public int cost(){
        return basePizza.cost();
    }
}
