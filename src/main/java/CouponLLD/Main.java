package CouponLLD;

import CouponLLD.Enum.ProductType;
import CouponLLD.Products.Item1;
import CouponLLD.Products.Product;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Item1(100.0, 1, ProductType.MOBILE);
        Cart cart = new Cart();
        cart.addProduct(product1);
        System.out.println(cart.getPrice());
    }
}
