package CouponLLD.Products;

import CouponLLD.Enum.ProductType;

public class Item1 extends Product{
    public Item1(Double price, int id, ProductType productType) {
        super(price, id, productType);
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
