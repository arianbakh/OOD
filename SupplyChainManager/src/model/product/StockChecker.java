package model.product;

import java.util.ArrayList;
import java.util.TimerTask;

import model.productOrder.ProductOrder;
import model.repository.ProductOrderRepository;
import model.repository.ProductRepository;

public class StockChecker extends TimerTask {

	@Override
	public void run() {
		ArrayList<Product> products = ProductRepository.getInstance().getAll();
		for (Product product: products){
			if (product.getCurrentStock() < product.getMinStock()){
				for(int i = 0; i < product.getMaxStock() - product.getCurrentStock(); i++){
					ProductOrder po = new ProductOrder(product);
					ProductOrderRepository.getInstance().save(po);
				}
			}
		}
	}

}