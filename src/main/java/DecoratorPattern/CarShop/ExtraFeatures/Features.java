package DecoratorPattern.CarShop.ExtraFeatures;

import DecoratorPattern.CarShop.BaseCar.Car;

public abstract class Features implements Car {
    Car car;
    public Features(Car car){
        this.car = car;
    }
    public int price(){
        return car.price();
    }

}
