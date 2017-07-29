package controller.customerOrder;

import java.util.ArrayList;
import java.util.Arrays;

import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.repository.ComponentRepository;
import model.repository.CustomerOrderRepository;
import model.repository.DelivererRepository;
import model.repository.ProductRepository;
import view.customerOrder.NewCustomerOrderView;
import view.customerOrder.SelectDeliverer;

public class CustomerOrderController {
    public static void startNewCustomerOrder(ArrayList<Object> data) {
    	new NewCustomerOrderView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void newCustomerOrderCancel(ArrayList<Object> data) {
    }

    public static void newCustomerOrderSubmit(ArrayList<Object> data) {
    	Product product;
    	String productName = "";
    	ArrayList<Component> components = new ArrayList<>();
    	for (Object c: (Object[])data.get(0)){
    		Component comp = (Component)c;
    		components.add(comp);
    		productName += comp.toString() + ",";
    	}
    	ArrayList<Product> productsIfAny = ProductRepository.getInstance().filter(components);
    	if (productsIfAny.size() > 0) {
    		product = productsIfAny.get(0);
    	} else {
    		product = new Product(productName.substring(0, productName.length()-1), components);
    		ProductRepository.getInstance().save(product);
    	}
    	CustomerOrder newCustomerOrder = new CustomerOrder(product);
    	CustomerOrderRepository.getInstance().save(newCustomerOrder);
    }

    public static void startSelectDeliverer(ArrayList<Object> data) {
    	new SelectDeliverer(CustomerOrderRepository.getInstance().getAll(),
    			DelivererRepository.getInstance().getAll()).setVisible(true);;
    }

    public static void selectDelivererCancel(ArrayList<Object> data) {
    }

    public static void selectDelivererSubmit(ArrayList<Object> data) {
    	CustomerOrder co = (CustomerOrder)data.get(0);
    	Deliverer del = (Deliverer)data.get(1);
    	co.setDeliverer(del);
    }

    public static void startFilterCustomerOrders(ArrayList<Object> data) {
    }

    public static void selectComponentsCancel(ArrayList<Object> data) {
    }

    public static void selectComponentsNext(ArrayList<Object> data) {
    }

    public static void customerOrderListReturn(ArrayList<Object> data) {
    }
}
