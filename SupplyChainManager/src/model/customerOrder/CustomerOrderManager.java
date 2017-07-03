package model.customerOrder;

import database.DataBase;
import model.product.ComponentManager;
import model.product.Product;

public class CustomerOrderManager {
	private static CustomerOrderManager customerOrderManager;
	
	private CustomerOrderManager() {
	}
	
	public static CustomerOrderManager getCustomerOrderManager(){
		if (customerOrderManager == null)
			customerOrderManager = new CustomerOrderManager();
		return customerOrderManager;
	}
	
	public CustomerOrder createCustomerOrder(Product product){
		CustomerOrder newCustomerOrder = new CustomerOrder(product);
		DataBase.getDB().addCustomerOrder(newCustomerOrder);
		return newCustomerOrder;
	}
	
}
