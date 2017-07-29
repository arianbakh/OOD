package model.productOrder;

import java.util.ArrayList;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import model.order.Order;
import model.product.Product;

@DatabaseTable(tableName = "ProductOrder")
public class ProductOrder extends Order {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true)
    private Product product;
    @DatabaseField(foreign = true)
    private ProductOrderReport report;
    @DatabaseField
    private Date orderTime;
    private ArrayList<Supplier> suppliers;

    public ProductOrder() {
        this.orderTime = new Date(); // set to current time
    } // empty constructor required by ORMLite

    public ProductOrder(Product product) {
        this.orderTime = new Date(); // set to current time
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public ProductOrderReport getReport() {
        return report;
    }

    public void setReport(ProductOrderReport report) {
        this.report = report;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
