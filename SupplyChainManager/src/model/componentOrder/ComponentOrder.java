package model.componentOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.Order;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;

import java.util.Date;

@DatabaseTable(tableName = "ComponentOrder")
public class ComponentOrder extends Order {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;
    @DatabaseField
    private Date orderTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ComponentOrderReport report;

    public ComponentOrder() {
        this.orderTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    public ComponentOrder(Supplier supplier) {
        this.orderTime = new Date();  // set to current time
        this.supplier = supplier;
        ComponentOrderRepository.getInstance().create(this);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        ComponentOrderRepository.getInstance().save(this);
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setReport(ComponentOrderReport report) {
        this.report = report;
        ComponentOrderRepository.getInstance().save(this);
    }

    public ComponentOrderReport getReport() {
        return report;
    }

    @Override
    public String toString() {
        return " سفارش مولفه‌ی " + this.supplier.getName();
    }


}
