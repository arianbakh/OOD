package db;

import java.util.ArrayList;

public class ProductOrder extends DataBaseObject{

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
