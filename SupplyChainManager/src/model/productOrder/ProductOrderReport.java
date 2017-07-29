package model.productOrder;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import model.order.OrderReport;
import model.order.Person;

@DatabaseTable(tableName = "ProductOrderReport")
public class ProductOrderReport extends OrderReport {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true)
    private ProductOrder order;
    @DatabaseField(foreign = true)
    private Person responsiblePerson;

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

    @Override
    public String toString() {
        return id.toString();
    }
}
