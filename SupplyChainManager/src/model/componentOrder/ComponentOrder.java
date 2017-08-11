package model.componentOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.Order;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;

@DatabaseTable(tableName = "ComponentOrder")
public class ComponentOrder extends Order {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ComponentOrderReport report;

    public ComponentOrder() {
    }  // empty constructor required by ORMLite

    public ComponentOrder(Supplier supplier) {
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
