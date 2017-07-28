package controller.product;

import java.util.ArrayList;

import model.product.Product;
import model.repository.ProductRepository;
import view.product.StockCheckView;

public class ProductController {
    public static void startSetProductStock(ArrayList<Object> data) {
    }

    public static void selectProductMinMaxCancel(ArrayList<Object> data) {
    }

    public static void selectProductMinMaxSubmit(ArrayList<Object> data) {
    }

    public static void startViewStock(ArrayList<Object> data) {
    	ArrayList<Product> products = ProductRepository.getInstance().getAll();
    	new StockCheckView(products).setVisible(true);
    }

    public static void stockCheckReturn(ArrayList<Object> data) {
    }

    public static void startFilterProducts(ArrayList<Object> data) {
    }

    public static void selectComponentsCancel(ArrayList<Object> data) {
    }

    public static void selectComponentsNext(ArrayList<Object> data) {
    }

    public static void productListReturn(ArrayList<Object> data) {
    }
}
