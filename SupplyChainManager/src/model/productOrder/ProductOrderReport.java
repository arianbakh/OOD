package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.ProductOrderReportRepository;

import java.util.Date;

@DatabaseTable(tableName = "ProductOrderReport")
public class ProductOrderReport extends OrderReport {
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ProductOrder order;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Person responsiblePerson;

    public ProductOrderReport() {
        this.readyTime = new Date();  // set to current time
    };  // empty constructor required by ORMLite

    public ProductOrderReport(ProductOrder productOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = productOrder;
        this.readyTime = new Date();  // set to current time
        this.responsiblePerson = responsiblePerson;
        ProductOrderReportRepository.getInstance().create(this);
    }

    public void setResponsiblePerson(Person person){
    	this.responsiblePerson = person;
        ProductOrderReportRepository.getInstance().save(this);
    }
    
    public Date getReadyTime() {
        return readyTime;
    }

    @Override
    public String toString() {
        return "ProductOrderReport";
    }
}
