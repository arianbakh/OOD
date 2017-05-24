import java.util.ArrayList;
import java.util.TimerTask;

public class CheckStock extends TimerTask{

	@Override
	public void run() {
s		ArrayList<Product> products = DataBase.getDB().getProducts();
		for (Product product: products){
			if (product.getStock() < product.getMinStock()){
				for(int i = 0; i < product.getMaxStock() - product.getStock(); i++){
					ProductOrder po = new ProductOrder(product);
					po.save();
				}
			}
		}
	}

}
