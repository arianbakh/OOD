package model.product;

import java.util.ArrayList;

import database.DataBase;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderManager;

public class ProductManager {
	private static ProductManager productManager;
	
	private ProductManager(){
		
	}
	
	public static ProductManager getProductManager(){
		if (productManager == null)
			productManager = new ProductManager();
		return productManager;
	}
	
	public ArrayList<Product> getAll(){
		return DataBase.getDB().getProducts();
	}
	
	public Product createProductManager(String name, ArrayList<Component> components, int minStock, int maxStock) {
		Product newProduct = new Product(name, components, minStock, maxStock);
		DataBase.getDB().addProduct(newProduct);
		return newProduct;
		
	}
	
	public ArrayList<Product> filter(ArrayList<Component> components){
		ArrayList<Product> allProducts = this.getAll();
		ArrayList<Product> result = new ArrayList<>();
		for (Product product: allProducts){
			if (product.getComponents().equals(components)){
				result.add(product);
			}
		}
		return result;
	}

}
