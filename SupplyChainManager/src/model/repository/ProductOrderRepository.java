package model.repository;

import model.product.Product;
import model.productOrder.ProductOrder;

import java.util.ArrayList;

public class ProductOrderRepository extends Repository<ProductOrder> {
    private static ProductOrderRepository productOrderRepository;

    private ProductOrderRepository() {
    }

    public static ProductOrderRepository getInstance() {
        if (productOrderRepository == null) {
            productOrderRepository = new ProductOrderRepository();
        }
        return productOrderRepository;
    }

    public ArrayList<ProductOrder> getByProduct(Product product) {
        ArrayList<ProductOrder> productOrders = new ArrayList<>();
        for (ProductOrder productOrder : getAll()) {
            if (productOrder.getProduct() == product) {
                productOrders.add(productOrder);
            }
        }
        return productOrders;
    }
}
