package model.product;

import model.productOrder.Supplier;

import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Component")
public class Component {
	@DatabaseField(generatedId = true)
	private Integer id;
	@DatabaseField
    private String name;
	@ForeignCollectionField(eager = true, foreignFieldName = "component")
    private Collection<Supplier> suppliers; // can't be ArrayList because of ORMLite

    public Component() {}; // empty constructor required by ORMLite

    public Component(String name) {
        this.name = name;
        suppliers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Supplier> getSuppliers() {
        return new ArrayList<Supplier>(suppliers);
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int hashCode() {
    	return this.name.hashCode();
    }
}
