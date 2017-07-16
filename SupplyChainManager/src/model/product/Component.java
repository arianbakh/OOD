package model.product;

import model.productOrder.Supplier;

import java.util.ArrayList;

public class Component {
    private String name;
    private ArrayList<Supplier> suppliers;

    public Component(String name) {
        this.name = name;
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
}
