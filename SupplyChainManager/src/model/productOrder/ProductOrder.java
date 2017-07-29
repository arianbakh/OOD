package model.productOrder;

import model.customerOrder.CustomerOrder;
import model.order.Order;
import model.product.Product;

import java.util.ArrayList;

public class ProductOrder extends Order {
	private static int idIndex;
    private Product product;
    private ArrayList<Supplier> suppliers;
    private int id;

    public ProductOrder(Product product) {
        this.product = product;
        ProductOrder.idIndex++;
        this.id = ProductOrder.idIndex;
    }

    public Product getProduct() {
        return product;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
    
    @Override
    public String toString() {
    	return "سفارش محصول " + this.id ;
    }
}
