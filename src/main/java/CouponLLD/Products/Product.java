package CouponLLD.Products;

import CouponLLD.Enum.ProductType;

public abstract class Product {
    Double price;
    int id;
    ProductType productType;
    public Product(Double price, int id, ProductType productType){
        this.price = price;
        this.id = id;
        this.productType = productType;
    }
    public Product(){}

    public abstract Double getPrice();
    public ProductType getType(){
        return productType;
    }
}
