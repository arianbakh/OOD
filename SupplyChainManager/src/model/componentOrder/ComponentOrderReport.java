package model.componentOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.ComponentOrderReportRepository;

import java.util.Date;

@DatabaseTable(tableName = "OrderReport")
public class ComponentOrderReport extends OrderReport {
    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ComponentOrder order;
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Person responsiblePerson;

    public ComponentOrderReport() {
        this.readyTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    public ComponentOrderReport(ComponentOrder componentOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.readyTime = new Date();  // set to current time
        this.order = componentOrder;
        this.responsiblePerson = responsiblePerson;
        ComponentOrderReportRepository.getInstance().create(this);
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
