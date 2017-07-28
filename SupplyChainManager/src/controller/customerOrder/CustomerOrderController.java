package controller.customerOrder;

import java.util.ArrayList;

import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.repository.CustomerOrderRepository;
import model.repository.DelivererRepository;
import view.customerOrder.SelectDeliverer;

public class CustomerOrderController {
    public static void startNewCustomerOrder(ArrayList<Object> data) {
    }

    public static void newCustomerOrderCancel(ArrayList<Object> data) {
    }

    public static void newCustomerOrderSubmit(ArrayList<Object> data) {
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
