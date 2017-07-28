package model.product;

import java.util.ArrayList;

public class Product {
    private String name;
    private ArrayList<Component> components;
    private int minStock;
    private int maxStock;
    private int currentStock;

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
