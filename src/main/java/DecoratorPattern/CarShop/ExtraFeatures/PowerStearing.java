package DecoratorPattern.CarShop.ExtraFeatures;

import DecoratorPattern.CarShop.BaseCar.Car;

public class PowerStearing extends Features{
    public PowerStearing(Car car){
        super(car);
    }

    @Override
    public int price() {
        return super.price() + 50;
    }
}
