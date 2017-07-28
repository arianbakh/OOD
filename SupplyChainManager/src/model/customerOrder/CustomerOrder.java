package model.customerOrder;

import model.order.Order;
import model.product.Product;

public class CustomerOrder extends Order {
	private static int idIndex;
    private Product product;
    private Deliverer deliverer;
    private int id;

    public CustomerOrder(Product product) {
        this.product = product;
        CustomerOrder.idIndex++;
        this.id = CustomerOrder.idIndex;
    }

    public Product getProduct() {
        return product;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }
    
    @Override
    public String toString() {
    	return "سفارش مشتری " + this.id ;
    }
}
