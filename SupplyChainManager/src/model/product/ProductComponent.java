package model.product;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.ModelBase;

@DatabaseTable(tableName = "ProductComponent")
public class ProductComponent extends ModelBase {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Product product;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Component component;

    public ProductComponent() {
    }  // empty constructor required by ORMLite

    ProductComponent(Product product, Component component) {
        this.product = product;
        this.component = component;
    }

    public Product getProduct() {
        return product;
    }

    public Component getComponent() {
        return component;
    }
}
