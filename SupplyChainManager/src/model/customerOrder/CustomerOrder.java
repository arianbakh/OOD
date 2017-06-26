package model.customerOrder;

import database.DataBase;
import database.DataBaseObject;
import model.order.Order;
import model.product.Product;

public class CustomerOrder extends Order implements DataBaseObject{
	private Deliverer deliverer;
	private Product product;
	
	public CustomerOrder(Product product){
		this.product = product;
	}
	
	public void setDeliverer(Deliverer deliverer) {
		this.deliverer = deliverer;
	}
	
	public Deliverer getDeliverer() {
		return deliverer;
	}
	
	public Product getProduct() {
		return product;
	}

	@Override
	public void save() {
		DataBase.getDB().addCustomerOrder(this);
	}

}
