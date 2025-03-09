package DecoratorPattern.CarShop;

import DecoratorPattern.CarShop.BaseCar.Car;
import DecoratorPattern.CarShop.BaseCar.PremiumCar;
import DecoratorPattern.CarShop.ExtraFeatures.PowerStearing;

public class Main {
    public static void main(String[] args) {
        Car car = new PowerStearing(new PremiumCar());
        System.out.println(car.price());
    }
}
