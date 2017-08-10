package controller.customerOrder;

import java.util.ArrayList;

import model.customerOrder.Deliverer;
import model.repository.DelivererRepository;
import view.customerOrder.DeliverersListView;
import view.customerOrder.SetDeliverersPropertiesView;

public class DelivererController {
    public static void startSetDelivererProperties(ArrayList<Object> data) {
    	new SetDeliverersPropertiesView().setVisible(true);;
    }

    public static void setDelivererPropertiesCancel(ArrayList<Object> data) {
    }

    public static void setDelivererPropertiesSubmit(ArrayList<Object> data) {
    	String name = (String)data.get(0);
    	String properties = (String)data.get(1);
    	if (name.trim().equals("")){
    		System.err.println("Empty name is not allowed");
    		return;
    	}
    	Deliverer newDeliverer = new Deliverer(name, properties);
    	DelivererRepository.getInstance().save(newDeliverer);
    }

    public static void startGetDeliverers(ArrayList<Object> data) {
    	new DeliverersListView(DelivererRepository.getInstance().getAll()).setVisible(true);
    }

    public static void deliverersListReturn(ArrayList<Object> data) {
    }
}
