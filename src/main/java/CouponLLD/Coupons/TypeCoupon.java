package CouponLLD.Coupons;

import CouponLLD.Enum.ProductType;
import CouponLLD.Products.Product;

public class TypeCoupon extends Coupon{
    int discount;
    Product product;
    ProductType productType;
    public TypeCoupon(Product product, int discount, ProductType type){
        this.product = product;
        this.discount = discount;
        this.productType = type;
    }
    @Override
    public Double getPrice() {
        if(ProductType.MOBILE == productType){
            return product.getPrice() - (product.getPrice() * (discount/100.0));
        }
        return product.getPrice();
    }
}
