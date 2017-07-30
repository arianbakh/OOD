package controller.productOrder;

import java.util.ArrayList;

import model.product.Product;
import model.repository.CustomerOrderRepository;
import model.repository.ProductOrderRepository;
import view.customerOrder.CustomerOrderListView;
import view.productOrder.ProductOrderListView;

public class ProductOrderController {
    public static void startFilterProductOrders(ArrayList<Object> data) {
    	Product product = (Product)data.get(0);
    	new ProductOrderListView(ProductOrderRepository.getInstance().getByProduct(product)).setVisible(true);;
    }

    public static void selectComponentsCancel(ArrayList<Object> data) {
    }

    public static void selectComponentsNext(ArrayList<Object> data) {
    }

    public static void productOrderListReturn(ArrayList<Object> data) {
    }
}
