package model.customerOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.Order;
import model.product.Product;
import model.repository.CustomerOrderRepository;

import java.util.Date;

@DatabaseTable(tableName = "CustomerOrder")
public class CustomerOrder extends Order {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Deliverer deliverer;
    @DatabaseField
    private Date orderTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CustomerOrderReport report;

    public CustomerOrder() {
        this.orderTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    public CustomerOrder(Product product) {
        this.product = product;
        this.orderTime = new Date();  // set to current time
        CustomerOrderRepository.getInstance().create(this);
    }

    public Product getProduct() {
        return product;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
        CustomerOrderRepository.getInstance().save(this);
    }

    public CustomerOrderReport getReport() {
        return report;
    }

    public void setReport(CustomerOrderReport report) {
        this.report = report;
        CustomerOrderRepository.getInstance().save(this);
    }

    public Date getOrderTime() {
        return orderTime;
    }

    @Override
    public String toString() {
        return " سفارش مشتری " + product.getName();
    }
}
