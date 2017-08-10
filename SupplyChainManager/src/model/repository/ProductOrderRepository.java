package model.repository;

import model.product.Product;
import model.productOrder.ProductOrder;

import java.sql.SQLException;
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

    @Override
    public void create(ProductOrder productOrder) {
        super.create(productOrder);
        try {
            getDao().assignEmptyForeignCollection(productOrder, "productOrderSuppliers");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
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

    public ArrayList<ProductOrder> getByProductAndFilterNotDone(Product product) {
        ArrayList<ProductOrder> productOrders = new ArrayList<>();
        for (ProductOrder productOrder : getAll()) {
            if (productOrder.getProduct() == product && productOrder.getReport() == null) {
                productOrders.add(productOrder);
            }
        }
        return productOrders;
    }
}
