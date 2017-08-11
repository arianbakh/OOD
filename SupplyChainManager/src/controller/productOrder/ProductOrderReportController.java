package controller.productOrder;

import model.order.Person;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderReport;
import model.repository.PersonRepository;
import model.repository.ProductOrderReportRepository;
import model.repository.ProductOrderRepository;
import view.productOrder.NewProductOrderReportView;
import view.productOrder.ProductOrderReportListView;
import view.productOrder.ProductOrderSelectionView;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderReportController {
    public static void startNewProductOrderReport(ArrayList<Object> data) {
        List<ProductOrder> productOrders = ProductOrderRepository.getInstance().getAll();
        List<Person> persons = PersonRepository.getInstance().getAll();
        new NewProductOrderReportView(productOrders, persons).setVisible(true);
    }

    public static void newProductOrderReportCancel(ArrayList<Object> data) {
    }

    public static void newProductOrderReportSubmit(ArrayList<Object> data) {
        ProductOrder productOrder = (ProductOrder) data.get(0);
        Person person = (Person) data.get(1);
        if (productOrder.getReport() == null) {
            ProductOrderReport productOrderReport = new ProductOrderReport(productOrder, person);
            productOrder.setReport(productOrderReport);
            productOrder.getProduct().increaseStock();
        } else {
            ProductOrderReport productOrderReport = productOrder.getReport();
            productOrderReport.setResponsiblePerson(person);
        }
    }

    public static void startGetProductOrderReport(ArrayList<Object> data) {
        List<ProductOrder> productOrders = ProductOrderRepository.getInstance().getAll();
        new ProductOrderSelectionView(productOrders).setVisible(true);
    }

    public static void productOrderSelectionCancel(ArrayList<Object> data) {
    }

    public static void productOrderSelectionNext(ArrayList<Object> data) {
        ProductOrder productOrder = (ProductOrder) data.get(0);
        new ProductOrderReportListView(productOrder).setVisible(true);
    }

    public static void productOrderReportListReturn(ArrayList<Object> data) {
    }
}
