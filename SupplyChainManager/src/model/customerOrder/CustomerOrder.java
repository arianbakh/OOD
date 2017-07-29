package model.customerOrder;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

import model.order.Order;
import model.product.Product;

public class CustomerOrder extends Order {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true)
    private Product product;
    @DatabaseField(foreign = true)
    private Deliverer deliverer;
    @DatabaseField
    private Date orderTime;

    public CustomerOrder() {
        this.orderTime = new Date(); // set to current time
    } // empty constructor required by ORMLite

    public CustomerOrder(Product product) {
        this.product = product;
        this.orderTime = new Date(); // set to current time
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

    public Date getOrderTime() {
        return orderTime;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
