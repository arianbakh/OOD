package model.product;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Product")
public class Product {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private String name;
    private ArrayList<Component> components;
    @DatabaseField
    private int minStock;
    @DatabaseField
    private int maxStock;
    @DatabaseField
    private int currentStock;

    public Product() {} // empty constructor required by ORMLite

    public Product(String name, ArrayList<Component> components) {
        this.name = name;
        this.components = components;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public void increaseStock() {
        currentStock++;
    }

    public void decreaseStock() {
        currentStock--;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    @Override
    public String toString() {
        return name;
    }
}
