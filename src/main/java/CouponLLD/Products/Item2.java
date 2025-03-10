package CouponLLD.Products;

import CouponLLD.Enum.ProductType;

public class Item2 extends Product{

    public Item2(Double price, int id, ProductType productType){
        super(price, id, productType);
    }
    @Override
    public Double getPrice() {
        return price;
    }
}
