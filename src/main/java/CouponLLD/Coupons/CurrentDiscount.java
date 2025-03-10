package CouponLLD.Coupons;

import CouponLLD.Products.Product;

public class CurrentDiscount extends Coupon{
    Product product;
    int discount;
    public CurrentDiscount(Product product, int discount){
        this.product = product;
        this.discount = discount;
    }
    @Override
    public Double getPrice() {
        return product.getPrice() - (product.getPrice() * (discount/100.0));
    }
}
