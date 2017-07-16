package model.productReview;

import model.product.Product;

public class ProductTextReview {
    private Product product;
    private String text;

    public ProductTextReview(Product product, String text) {
        this.product = product;
        this.text = text;
    }

    public Product getProduct() {
        return product;
    }

    public String getText() {
        return text;
    }
}
