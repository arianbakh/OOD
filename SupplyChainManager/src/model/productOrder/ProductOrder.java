package model.productOrder;

import java.util.ArrayList;

import database.DataBase;
import database.DataBaseObject;
import model.Supplier;
import model.order.Order;
import model.product.Product;

public class ProductOrder extends Order implements DataBaseObject{

	private Product product;
	private ArrayList<Supplier> suppliers = new ArrayList<>();
	
	public ProductOrder(Product product){
		this.product = product;
	}
	
	public void addComponentSupplier(Supplier supplier) {
		this.suppliers.add(supplier);
	}
	
	public void removeComponentSupplier(Supplier supplier) {
		this.suppliers.remove(supplier);
	}

	@Override
	public void save() {
		DataBase.getDB().addProductOrder(this);
		
	}
}
