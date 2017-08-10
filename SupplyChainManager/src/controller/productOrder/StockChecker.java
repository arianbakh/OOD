package controller.productOrder;

import java.util.ArrayList;
import java.util.TimerTask;

import model.product.Product;
import model.productOrder.ProductOrder;
import model.repository.ProductOrderRepository;
import model.repository.ProductRepository;

public class StockChecker extends TimerTask {

	@Override
	public void run() {
		ArrayList<Product> products = ProductRepository.getInstance().getAll();
		for (Product product: products){
			int currentStockAndOrders = product.getCurrentStock() + ProductOrderRepository.getInstance().getByProductAndFilterNotDone(product).size(); 
			if ( currentStockAndOrders < product.getMinStock()){
				for(int i = 0; i < product.getMaxStock() - product.getCurrentStock(); i++){
					ProductOrder po = new ProductOrder(product);
					ProductOrderRepository.getInstance().save(po);
				}
			}
		}
	}

}