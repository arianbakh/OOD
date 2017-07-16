package model.productOrder;

import model.product.Component;

public class Supplier {
    private String name;
    private int price;
    private Component component;

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
}
