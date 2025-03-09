package DecoratorPattern.CarShop.BaseCar;

import DecoratorPattern.CarShop.BaseCar.Car;

public class SimpleCar implements Car {

    @Override
    public int price() {
        return 100;
    }
}
