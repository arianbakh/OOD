package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import model.product.Component;

@DatabaseTable(tableName = "Supplier")
public class Supplier {
	@DatabaseField(generatedId = true)
	private Integer id;
	@DatabaseField
    private String name;
	@DatabaseField
    private int price;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Component component;

	public Supplier() {}; // empty constructor required by ORMLite

    public Supplier(String name, int price, Component component) {
        this.name = name;
        this.price = price;
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Component getComponent() {
        return component;
    }

    @Override
    public String toString() {
        return name;
    }
}
