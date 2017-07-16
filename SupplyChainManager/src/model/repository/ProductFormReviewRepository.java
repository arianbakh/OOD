package model.repository;

import model.productReview.ProductFormReview;

public class ProductFormReviewRepository extends Repository<ProductFormReview> {
    private static ProductFormReviewRepository productFormReviewRepository;

    private ProductFormReviewRepository() {
    }

    public static ProductFormReviewRepository getInstance() {
        if (productFormReviewRepository == null) {
            productFormReviewRepository = new ProductFormReviewRepository();
        }
        return productFormReviewRepository;
    }
}
