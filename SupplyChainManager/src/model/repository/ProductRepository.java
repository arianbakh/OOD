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
    	ArrayList<Product> result = new ArrayList<>();
    	OUTER:
    	for (Product p: this.getAll()){
    		if (p.getComponents().size() != components.size())
    			continue;
    		for(Component c: p.getComponents()){
    			if (!components.contains(c))
    				continue OUTER;
    		}
    		result.add(p);
    	}
    	return result;
    }
    
    public ArrayList<Product> hasAll(ArrayList<Component> components) {
    	ArrayList<Product> result = new ArrayList<>();
    	OUTER:
    	for (Product p: this.getAll()){
    		for(Component c: components){
    			if (!p.getComponents().contains(c))
    				continue OUTER;
    		}
    		result.add(p);
    	}
    	return result;
    }

    private boolean exists(Product product) {
        return false;
    }
}
