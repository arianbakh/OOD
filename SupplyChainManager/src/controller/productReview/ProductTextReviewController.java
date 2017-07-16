package controller.productReview;

import model.product.Product;
import model.productReview.ProductTextReview;
import model.repository.ProductRepository;
import model.repository.ProductTextReviewRepository;
import view.productReview.SubmitTextView;

import java.util.ArrayList;

public class ProductTextReviewController {
    public static void startNewTextProductReview(ArrayList<Object> data) {
        new SubmitTextView(ProductRepository.getInstance().getAll()).setVisible(true);
    }

    public static void submitFormSubmit(ArrayList<Object> data) {
        Product product = (Product) data.get(0);
        String text = (String) data.get(1);
        ProductTextReview productTextReview = new ProductTextReview(product, text);
        ProductTextReviewRepository.getInstance().save(productTextReview);
    }

    public static void submitFormCancel(ArrayList<Object> data) {
    }
}
