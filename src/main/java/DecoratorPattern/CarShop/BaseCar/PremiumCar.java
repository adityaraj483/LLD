package DecoratorPattern.CarShop.BaseCar;

import DecoratorPattern.CarShop.BaseCar.Car;

public class PremiumCar implements Car {
    @Override
    public int price(){
        return 200;
    }
}
