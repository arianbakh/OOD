package model.repository;

import model.product.Product;

import java.util.ArrayList;

public class ProductRepository extends Repository<Product> {
    private static ProductRepository productRepository;
    private ArrayList<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
    }

    public static ProductRepository getInstance() {
        if(productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    @Override
    public ArrayList<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
