package controller.productOrder;

import model.product.Product;
import model.productOrder.ProductOrder;
import model.repository.ProductOrderRepository;
import model.repository.ProductRepository;

import java.util.List;
import java.util.TimerTask;

public class StockChecker extends TimerTask {

    @Override
    public void run() {
        List<Product> products = ProductRepository.getInstance().getAll();
        for (Product product : products) {
            int currentStockAndOrders = product.getCurrentStock() + ProductOrderRepository.getInstance().getByProductAndFilterNotDone(product).size();
            if (currentStockAndOrders < product.getMinStock()) {
                for (int i = 0; i < product.getMaxStock() - product.getCurrentStock(); i++) {
                    ProductOrder po = new ProductOrder(product);
                    ProductOrderRepository.getInstance().save(po);
                }
            }
        }
    }

}