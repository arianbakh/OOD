package model.componentOrder;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import model.order.OrderReport;
import model.order.Person;

@DatabaseTable(tableName = "OrderReport")
public class ComponentOrderReport extends OrderReport {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true)
    private ComponentOrder order;
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true)
    private Person responsiblePerson;

    public ComponentOrderReport() {
        this.readyTime = new Date(); // set to current time
    }; // empty constructor required by ORMLite

    public ComponentOrderReport(ComponentOrder componentOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.readyTime = new Date(); // set to current time
        this.order = componentOrder;
        this.responsiblePerson = responsiblePerson;
    }

    public ComponentOrder getOrder() {
        return order;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    @Override
    public String toString() {
//        return id.toString();
        return super.toString();
    }
}
