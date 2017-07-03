package controller.productOrder;

import java.util.ArrayList;

import model.order.Person;
import model.product.Product;
import model.productOrder.ProductOrderReportManager;
import view.SubmitProductReportFrame;

public class ProductOrderReportController {
	public static void newproductOrderReport(ArrayList<Object> data) {
		ProductOrderReportManager.getProductOrderReportManager().createProductOrder((Product)data.get(0), (ArrayList<Person>)data.get(1));
	}
	
	public static void newproductOrderReportDialogue(ArrayList<Object> data) {
    	new SubmitProductReportFrame().setVisible(true);
	}
}
