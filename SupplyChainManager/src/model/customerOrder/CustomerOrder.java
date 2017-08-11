package model.customerOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.Order;
import model.product.Product;
import model.repository.CustomerOrderRepository;

@DatabaseTable(tableName = "CustomerOrder")
public class CustomerOrder extends Order {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Deliverer deliverer;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CustomerOrderReport report;

    public CustomerOrder() {
    }  // empty constructor required by ORMLite

    public CustomerOrder(Product product) {
        this.product = product;
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

    @Override
    public String toString() {
        return " سفارش مشتری " + product.getName();
    }
}
