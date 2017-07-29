package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ProductOrderSupplier")
public class ProductOrderSupplier {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ProductOrder productOrder;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;

    public ProductOrderSupplier() {} // empty constructor required by ORMLite

    public ProductOrderSupplier(ProductOrder productOrder, Supplier supplier) {
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
