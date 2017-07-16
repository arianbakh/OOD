package model.componentOrder;

import model.order.OrderReport;
import model.order.Person;

public class ComponentOrderReport extends OrderReport {
    public ComponentOrderReport(ComponentOrder componentOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = componentOrder;
    }
}
