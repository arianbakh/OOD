package model.customerOrder;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

import model.order.OrderReport;
import model.order.Person;

public class CustomerOrderReport extends OrderReport {
    @DatabaseField
    private Date readyTime;
    
    public CustomerOrderReport() {
        this.readyTime = new Date(); // set to current time
    }; // empty constructor required by ORMLite
    
    public CustomerOrderReport(CustomerOrder customerOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = customerOrder;
        this.readyTime = new Date(); // set to current time
    }
    
    public Date getReadyTime() {
        return readyTime;
    }
}
