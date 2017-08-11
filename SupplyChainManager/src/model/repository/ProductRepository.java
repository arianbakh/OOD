package model.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.product.Component;
import model.product.Product;
import model.product.ProductComponent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository extends Repository<Product> {
    private static ProductRepository productRepository;
    private Dao<ProductComponent, Integer> productComponentDao;

    private ProductRepository() {
        try {
            productComponentDao = DaoManager.createDao(DatabaseHelper.getConnectionSource(), ProductComponent.class);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    @Override
    public void create(Product product) {
        super.create(product);
        try {
            getDao().assignEmptyForeignCollection(product, "productComponents");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<Product> filter(ArrayList<Component> components) {
        List<Product> products = hasAll(components);
        List<Product> productsToRemove = new ArrayList<>();
        for (Product product : products) {
            if (product.getComponents().size() != components.size()) {
                productsToRemove.add(product);
            }
        }
        products.removeAll(productsToRemove);
        return products;
    }

    public List<Product> hasAll(ArrayList<Component> components) {
        List<Product> products = getAll();
        for (Component component : components) {
            try {
                Map<String, Object> queryFields = new HashMap<>();
                queryFields.put("component_id", component);
                List<ProductComponent> productComponents = productComponentDao.queryForFieldValues(queryFields);
                List<Product> productsToRemove = new ArrayList<>();
                for (Product product : products) {
                    boolean containsComponent = false;
                    for (ProductComponent productComponent : productComponents) {
                        if (product.getId().equals(productComponent.getProduct().getId())) {
                            containsComponent = true;
                        }
                    }
                    if (!containsComponent) {
                        productsToRemove.add(product);
                    }
                }
                products.removeAll(productsToRemove);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return products;
    }
}
