package controller.componentOrder;

import java.util.ArrayList;

import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.order.Person;
import model.repository.ComponentOrderRepository;
import model.repository.CustomerOrderRepository;
import model.repository.PersonRepository;
import view.componentOrder.NewComponentOrderReportView;
import view.customerOrder.NewCustomerOrderReportView;

public class ComponentOrderReportController {
    public static void startNewComponentOrderReport(ArrayList<Object> data) {
    	ArrayList<ComponentOrder> componentOrders = ComponentOrderRepository.getInstance().getAll();
    	ArrayList<Person> persons = PersonRepository.getInstance().getAll();
    	new NewComponentOrderReportView(componentOrders, persons).setVisible(true);
    }

    public static void newComponentOrderReportCancel(ArrayList<Object> data) {
    }

    public static void newComponentOrderReportSubmit(ArrayList<Object> data) {
    	ComponentOrder componentOrder = (ComponentOrder)data.get(0);
    	Person person = (Person)data.get(1);
    	ComponentOrderReport componentOrderReport = new ComponentOrderReport(componentOrder, person);
    	ComponentOrderRepository.getInstance().save(componentOrder);
    }

    public static void startGetComponentOrderReport(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForReportCancel(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForReportNext(ArrayList<Object> data) {
    }

    public static void componentOrderReportListReturn(ArrayList<Object> data) {
    }
}
