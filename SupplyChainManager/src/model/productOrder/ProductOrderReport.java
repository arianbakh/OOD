package model.productOrder;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

import model.order.OrderReport;
import model.order.Person;

public class ProductOrderReport extends OrderReport {
    @DatabaseField
    private Date readyTime;

    public ProductOrderReport() {
        this.readyTime = new Date(); // set to current time
    }; // empty constructor required by ORMLite
    
    public ProductOrderReport(ProductOrder productOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = productOrder;
        this.readyTime = new Date(); // set to current time
    }
    
    public Date getReadyTime() {
        return readyTime;
    }
}
