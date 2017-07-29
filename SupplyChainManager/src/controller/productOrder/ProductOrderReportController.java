package controller.productOrder;

import java.util.ArrayList;

import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.order.Person;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderReport;
import model.repository.CustomerOrderRepository;
import model.repository.PersonRepository;
import model.repository.ProductOrderRepository;
import view.customerOrder.NewCustomerOrderReportView;
import view.productOrder.NewProductOrderReportView;

public class ProductOrderReportController {
    public static void startNewProductOrderReport(ArrayList<Object> data) {
    	ArrayList<ProductOrder> productOrders = ProductOrderRepository.getInstance().getAll();
    	ArrayList<Person> persons = PersonRepository.getInstance().getAll();
    	new NewProductOrderReportView(productOrders, persons).setVisible(true);;
    }

    public static void newProductOrderReportCancel(ArrayList<Object> data) {
    }

    public static void newProductOrderReportSubmit(ArrayList<Object> data) {
    	ProductOrder productOrder = (ProductOrder)data.get(0);
    	Person person = (Person)data.get(1);
    	ProductOrderReport productOrderReport = new ProductOrderReport(productOrder, person);
    	ProductOrderRepository.getInstance().save(productOrder);
    }

    public static void startGetProductOrderReport(ArrayList<Object> data) {
    }

    public static void productOrderSelectionCancel(ArrayList<Object> data) {
    }

    public static void productOrderSelectionNext(ArrayList<Object> data) {
    }

    public static void productOrderReportListReturn(ArrayList<Object> data) {
    }
}
