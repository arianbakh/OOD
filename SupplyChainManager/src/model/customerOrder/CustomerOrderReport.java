package model.customerOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.CustomerOrderReportRepository;

import java.util.Date;

@DatabaseTable(tableName = "CustomerOrderReport")
public class CustomerOrderReport extends OrderReport {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CustomerOrder order;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Person responsiblePerson;

    public CustomerOrderReport() {
        this.readyTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    public CustomerOrderReport(CustomerOrder customerOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = customerOrder;
        this.readyTime = new Date();  // set to current time
        this.responsiblePerson = responsiblePerson;
        CustomerOrderReportRepository.getInstance().create(this);
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Person person) {
        this.responsiblePerson = person;
        CustomerOrderReportRepository.getInstance().save(this);
    }

    public Date getReadyTime() {
        return readyTime;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
