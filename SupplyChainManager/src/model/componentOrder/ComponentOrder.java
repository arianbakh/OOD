package model.componentOrder;

import model.order.Order;
import model.productOrder.Supplier;

public class ComponentOrder extends Order {
    private Supplier supplier;

    public ComponentOrder(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
