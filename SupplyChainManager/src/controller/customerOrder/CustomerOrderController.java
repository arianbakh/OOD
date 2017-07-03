package controller.customerOrder;

import java.util.ArrayList;

import model.customerOrder.CustomerOrderManager;
import model.product.Component;
import model.product.Product;
import model.product.ProductManager;

public class CustomerOrderController {
	public static void newCustomerOrder(ArrayList<Object> components){
		ArrayList<Component> castedComponents = new ArrayList<>();
		for (Object obj: components){
			castedComponents.add((Component)obj);
		}
		ArrayList<Product> products = ProductManager.getProductManager().filter(castedComponents);
		Product product;
		if (products.size() > 0){
			product = products.get(0);
		} else {
			product = ProductManager.getProductManager().createProductManager("پروداکت جدید", castedComponents, 1, 5);
		}
		CustomerOrderManager.getCustomerOrderManager().createCustomerOrder(product);
	}
}
