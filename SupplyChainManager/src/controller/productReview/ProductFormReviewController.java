package controller.productReview;

import model.product.Product;
import model.productReview.ProductFormReview;
import model.repository.ProductFormReviewRepository;
import model.repository.ProductRepository;
import view.productReview.SubmitFormView;

import java.util.ArrayList;

public class ProductFormReviewController {
    public static void startNewFormProductReview(ArrayList<Object> data) {
        new SubmitFormView(ProductRepository.getInstance().getAll()).setVisible(true);
    }

    public static void submitFormCancel(ArrayList<Object> data) {
    }

    public static void submitFormSubmit(ArrayList<Object> data) {
        Product product = (Product) data.get(0);
        int quality = (int) data.get(1);
        int delivery = (int) data.get(2);
        ProductFormReview productFormReview = new ProductFormReview(quality, delivery, product);
        ProductFormReviewRepository.getInstance().save(productFormReview);
    }
}
