package controller.componentOrder;

import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.order.Person;
import model.repository.ComponentOrderReportRepository;
import model.repository.ComponentOrderRepository;
import model.repository.PersonRepository;
import view.componentOrder.ComponentOrderReportListView;
import view.componentOrder.ComponentOrderSelectionView;
import view.componentOrder.NewComponentOrderReportView;

import java.util.ArrayList;
import java.util.List;

public class ComponentOrderReportController {
    public static void startNewComponentOrderReport(ArrayList<Object> data) {
        List<ComponentOrder> componentOrders = ComponentOrderRepository.getInstance().getAll();
        List<Person> persons = PersonRepository.getInstance().getAll();
        new NewComponentOrderReportView(componentOrders, persons).setVisible(true);
    }

    public static void newComponentOrderReportCancel(ArrayList<Object> data) {
    }

    public static void newComponentOrderReportSubmit(ArrayList<Object> data) {
        ComponentOrder componentOrder = (ComponentOrder) data.get(0);
        Person person = (Person) data.get(1);
        ComponentOrderReport componentOrderReport = new ComponentOrderReport(componentOrder, person);
        componentOrder.setReport(componentOrderReport);
    }

    public static void startGetComponentOrderReport(ArrayList<Object> data) {
        List<ComponentOrder> componentOrders = ComponentOrderRepository.getInstance().getAll();
        new ComponentOrderSelectionView(componentOrders).setVisible(true);
    }

    public static void componentOrderSelectionForReportCancel(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForReportNext(ArrayList<Object> data) {
        ComponentOrder componentOrder = (ComponentOrder) data.get(0);
        new ComponentOrderReportListView(componentOrder).setVisible(true);
    }

    public static void componentOrderReportListReturn(ArrayList<Object> data) {
    }
}
