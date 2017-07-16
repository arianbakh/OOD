package model.productOrder;

import model.order.Order;
import model.product.Product;

import java.util.ArrayList;

public class ProductOrder extends Order {
    private Product product;
    private ArrayList<Supplier> suppliers;

    public ProductOrder(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
