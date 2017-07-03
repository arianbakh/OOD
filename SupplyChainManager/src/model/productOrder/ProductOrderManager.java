package model.productOrder;

import java.util.ArrayList;

import database.DataBase;
import model.order.Person;
import model.product.Component;
import model.product.ComponentManager;
import model.product.Product;

public class ProductOrderManager {
	private static ProductOrderManager productOrderManager;
	
	private ProductOrderManager(){
		
	}
	
	public static ProductOrderManager getProductOrderManager(){
		if (productOrderManager == null)
			productOrderManager = new ProductOrderManager();
		return productOrderManager;
	}
	
	public ArrayList<ProductOrder> getAll(){
		return DataBase.getDB().getProductOrders();
	}

}
