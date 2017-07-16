package model.customerOrder;

import model.order.OrderReport;
import model.order.Person;

public class CustomerOrderReport extends OrderReport {
    public CustomerOrderReport(CustomerOrder customerOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = customerOrder;
    }
}
