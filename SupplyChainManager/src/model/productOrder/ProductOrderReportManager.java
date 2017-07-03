package model.productOrder;

import java.util.ArrayList;

import database.DataBase;
import model.order.Person;
import model.product.Component;
import model.product.ComponentManager;
import model.product.Product;

public class ProductOrderReportManager {
	private static ProductOrderReportManager productOrderReportManager;
	
	private ProductOrderReportManager(){
		
	}
	
	public static ProductOrderReportManager getProductOrderReportManager(){
		if (productOrderReportManager == null)
			productOrderReportManager = new ProductOrderReportManager();
		return productOrderReportManager;
	}
	
	public ArrayList<ProductOrderReport> getAll(){
		return DataBase.getDB().getProductOrderReports();
	}
	
	public ProductOrderReport createProductOrder(Product product, ArrayList<Person> persons){
		ProductOrderReport newProductOrderReport = new ProductOrderReport(product, persons);
		DataBase.getDB().addProductOrderReport(newProductOrderReport);
		return newProductOrderReport;
	}
}
