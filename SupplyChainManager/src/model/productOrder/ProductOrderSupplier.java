package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.ModelBase;

@DatabaseTable(tableName = "ProductOrderSupplier")
public class ProductOrderSupplier extends ModelBase {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ProductOrder productOrder;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;

    public ProductOrderSupplier() {
    }  // empty constructor required by ORMLite

    ProductOrderSupplier(ProductOrder productOrder, Supplier supplier) {
        this.productOrder = productOrder;
        this.supplier = supplier;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
