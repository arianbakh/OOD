package model.repository;

import model.productReview.ProductTextReview;

public class ProductTextReviewRepository extends Repository<ProductTextReview> {
    private static ProductTextReviewRepository productTextReviewRepository;

    private ProductTextReviewRepository() {
    }

    public static ProductTextReviewRepository getInstance() {
        if (productTextReviewRepository == null) {
            productTextReviewRepository = new ProductTextReviewRepository();
        }
        return productTextReviewRepository;
    }
}
