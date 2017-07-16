package model.productReview;

import model.product.Product;

public class ProductFormReview {
    private int qualityRating;
    private int deliveryRating;
    private Product product;

    public ProductFormReview(int qualityRating, int deliveryRating, Product product) {
        this.qualityRating = qualityRating;
        this.deliveryRating = deliveryRating;
        this.product = product;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public Product getProduct() {
        return product;
    }
}
