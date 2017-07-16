package model.repository;

import model.product.Component;
import model.product.Product;

import java.util.ArrayList;

public class ProductRepository extends Repository<Product> {
    private static ProductRepository productRepository;

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public ArrayList<Product> filter(ArrayList<Component> components) {
        return null;
    }

    private boolean exists(Product product) {
        return false;
    }
}
