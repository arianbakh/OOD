package model.repository;

import model.product.Product;
import model.productOrder.ProductOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<ProductOrder> getByProduct(Product product) {
        try {
            return getDao().queryForEq("product_id", product);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public List<ProductOrder> getByProductAndFilterNotDone(Product product) {
        List<ProductOrder> productOrders = getByProduct(product);
        List<ProductOrder> productOrdersToRemove = new ArrayList<>();
        for (ProductOrder productOrder : productOrders) {
            if (productOrder.getReport() != null) {
                productOrdersToRemove.add(productOrder);
            }
        }
        productOrders.removeAll(productOrdersToRemove);
        return productOrders;
    }
}
