package model.repository;

import model.productReview.ProductTextReview;

import java.util.ArrayList;

public class ProductTextReviewRepository extends Repository<ProductTextReview> {
    private static ProductTextReviewRepository productTextReviewRepository;
    private ArrayList<ProductTextReview> productTextReviews;

    private ProductTextReviewRepository() {}

    public static ProductTextReviewRepository getInstance() {
        if(productTextReviewRepository == null) {
            productTextReviewRepository = new ProductTextReviewRepository();
        }
        return productTextReviewRepository;
    }

    @Override
    public ArrayList<ProductTextReview> getAll() {
        return productTextReviews;
    }

    @Override
    public void save(ProductTextReview productTextReview) {
        productTextReviews.add(productTextReview);
    }
}
