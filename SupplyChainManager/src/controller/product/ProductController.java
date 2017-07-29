package controller.product;

import java.util.ArrayList;

import model.product.Component;
import model.product.Product;
import model.repository.ComponentRepository;
import model.repository.ProductRepository;
import view.customerOrder.NewCustomerOrderView;
import view.product.SelectComponentsView;
import view.product.SelectProductMinMaxView;
import view.product.ShowFamiliarsView;
import view.product.StockCheckView;

public class ProductController {
    public static void startSetProductStock(ArrayList<Object> data) {
    	ArrayList<Product> products = ProductRepository.getInstance().getAll();
    	new SelectProductMinMaxView(products).setVisible(true);;
    }

    public static void selectProductMinMaxCancel(ArrayList<Object> data) {
    }

    public static void selectProductMinMaxSubmit(ArrayList<Object> data) {
    	Product product = (Product)data.get(0);
    	int min = (int)data.get(1);
    	int max = (int)data.get(2);
    	product.setMinStock(min);
    	product.setMaxStock(max);
    }

    public static void startViewStock(ArrayList<Object> data) {
    	ArrayList<Product> products = ProductRepository.getInstance().getAll();
    	new StockCheckView(products).setVisible(true);
    }

    public static void stockCheckReturn(ArrayList<Object> data) {
    }

    public static void startFilterProducts(ArrayList<Object> data) {
    	new SelectComponentsView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void selectComponentsCancel(ArrayList<Object> data) {
    }

    public static void selectComponentsNext(ArrayList<Object> data) {
    	ArrayList<Component> components = new ArrayList<>();
    	for (Object c: (Object[])data.get(0))
    		components.add((Component)c);
    	ArrayList<Product> familiarProducts = ProductRepository.getInstance().hasAll(components);
    	new ShowFamiliarsView(familiarProducts).setVisible(true);;
    }

    public static void productListReturn(ArrayList<Object> data) {
    }
}
