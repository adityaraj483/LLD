package DecoratorPattern.PizzaShop;

import DecoratorPattern.PizzaShop.BasePizza.IBasePizza;
import DecoratorPattern.PizzaShop.BasePizza.PlainBread;
import DecoratorPattern.PizzaShop.Toppings.Mushroom;

class Main{
    public static void main(String[] args) {
        IBasePizza pizza = new Mushroom(new PlainBread());
        System.out.println(pizza.cost());
    }
}
