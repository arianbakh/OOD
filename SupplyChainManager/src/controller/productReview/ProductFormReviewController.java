package controller.productReview;

import java.util.ArrayList;

import model.product.Product;
import model.productReview.ProductFormReview;
import model.productReview.ProductTextReview;
import model.repository.ProductFormReviewRepository;
import model.repository.ProductRepository;
import model.repository.ProductTextReviewRepository;
import view.productReview.SubmitFormView;

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
