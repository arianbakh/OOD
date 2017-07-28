package model.product;

import model.productOrder.Supplier;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Component")
public class Component {
	@DatabaseField(id = true)
    private String name;
    private ArrayList<Supplier> suppliers;

    public Component() {}; // empty constructor required by ORMLite

    public Component(String name) {
        this.name = name;
        suppliers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void addSupplier(String name, int price) {
        suppliers.add(new Supplier(name, price, this));
    }

    @Override
    public String toString() {
        return name;
    }
}
