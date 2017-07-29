package controller.componentOrder;

import java.util.ArrayList;

import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.order.Person;
import model.repository.ComponentOrderReportRepository;
import model.repository.ComponentOrderRepository;
import model.repository.CustomerOrderRepository;
import model.repository.PersonRepository;
import view.componentOrder.ComponentOrderReportListView;
import view.componentOrder.ComponentOrderSelectionView;
import view.componentOrder.NewComponentOrderReportView;
import view.customerOrder.CustomerOrderReportListView;
import view.customerOrder.CustomerOrderSelectionView;
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
    	ComponentOrderReportRepository.getInstance().save(componentOrderReport);
    	componentOrder.setReport(componentOrderReport);
    }

    public static void startGetComponentOrderReport(ArrayList<Object> data) {
    	ArrayList<ComponentOrder> componentOrders = ComponentOrderRepository.getInstance().getAll();
    	new ComponentOrderSelectionView(componentOrders).setVisible(true);
    }

    public static void componentOrderSelectionForReportCancel(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForReportNext(ArrayList<Object> data) {
    	ComponentOrder componentOrder = (ComponentOrder)data.get(0);
    	new ComponentOrderReportListView(componentOrder).setVisible(true);
    }

    public static void componentOrderReportListReturn(ArrayList<Object> data) {
    }
}
