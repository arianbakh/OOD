package model.customerOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.CustomerOrderReportRepository;

@DatabaseTable(tableName = "CustomerOrderReport")
public class CustomerOrderReport extends OrderReport {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CustomerOrder order;

    public CustomerOrderReport() {
    }  // empty constructor required by ORMLite

    public CustomerOrderReport(CustomerOrder customerOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = customerOrder;
        CustomerOrderReportRepository.getInstance().create(this);
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setResponsiblePerson(Person person) {
        super.setResponsiblePerson(person);
        CustomerOrderReportRepository.getInstance().save(this);
    }

    @Override
    public String toString() {
        return getId().toString();
    }
}
