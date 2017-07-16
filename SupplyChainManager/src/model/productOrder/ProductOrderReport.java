package model.productOrder;

import model.order.OrderReport;
import model.order.Person;

public class ProductOrderReport extends OrderReport {
    public ProductOrderReport(ProductOrder productOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = productOrder;
    }
}
