package model.customerOrder;

import model.order.Order;
import model.product.Product;

public class CustomerOrder extends Order {
    private Product product;
    private Deliverer deliverer;

    public CustomerOrder(Product product) {
        this.product = product;
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
}
