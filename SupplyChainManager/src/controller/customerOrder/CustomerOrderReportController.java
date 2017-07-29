package controller.customerOrder;

import java.util.ArrayList;

import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.order.Person;
import model.repository.CustomerOrderReportRepository;
import model.repository.CustomerOrderRepository;
import model.repository.PersonRepository;
import view.customerOrder.CustomerOrderReportListView;
import view.customerOrder.CustomerOrderSelectionView;
import view.customerOrder.NewCustomerOrderReportView;

public class CustomerOrderReportController {
    public static void startNewCustomerOrderReport(ArrayList<Object> data) {
    	ArrayList<CustomerOrder> customerOrders = CustomerOrderRepository.getInstance().getAll();
    	ArrayList<Person> persons = PersonRepository.getInstance().getAll();
    	new NewCustomerOrderReportView(customerOrders, persons).setVisible(true);
    }

    public static void newCustomerOrderReportCancel(ArrayList<Object> data) {
    }

    public static void newCustomerOrderReportSubmit(ArrayList<Object> data) {
    	CustomerOrder customerOrder = (CustomerOrder)data.get(0);
    	Person person = (Person)data.get(1);
    	CustomerOrderReport customerOrderReport = new CustomerOrderReport(customerOrder, person);
    	CustomerOrderReportRepository.getInstance().save(customerOrderReport);
    	customerOrder.submitReport(customerOrderReport);
    }

    public static void startGetCustomerOrderReport(ArrayList<Object> data) {
    	ArrayList<CustomerOrder> customerOrders = CustomerOrderRepository.getInstance().getAll();
    	new CustomerOrderSelectionView(customerOrders).setVisible(true);
    }

    public static void customerOrderSelectionCancel(ArrayList<Object> data) {
    }

    public static void customerOrderSelectionNext(ArrayList<Object> data) {
    	CustomerOrder customerOrder = (CustomerOrder)data.get(0);
    	new CustomerOrderReportListView(customerOrder).setVisible(true);
    }

    public static void customerOrderReportListReturn(ArrayList<Object> data) {
    }
}
