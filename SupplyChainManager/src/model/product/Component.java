package model.product;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.ModelBase;
import model.productOrder.Supplier;
import model.repository.ComponentRepository;
import model.repository.SupplierRepository;

import java.util.Collection;

@DatabaseTable(tableName = "Component")
public class Component extends ModelBase {
    @DatabaseField
    private String name;

    public Component() {
    }  // empty constructor required by ORMLite

    public Component(String name) {
        this.name = name;
        ComponentRepository.getInstance().create(this);
    }

    public String getName() {
        return name;
    }

    public Collection<Supplier> getSuppliers() {
        return SupplierRepository.getInstance().filterByComponent(this);
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
