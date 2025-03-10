package CouponLLD;

import CouponLLD.Coupons.CurrentDiscount;
import CouponLLD.Coupons.TypeCoupon;
import CouponLLD.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;

    public Cart(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        Product discountedProduct = new TypeCoupon(new CurrentDiscount(product, 20), 5, product.getType());
        products.add(discountedProduct);

    }

    public Double getPrice(){
        Double sum =0.0;
        for(int i=0;i<products.size();i++){
            sum += products.get(i).getPrice();
        }
        return sum;
    }
}
