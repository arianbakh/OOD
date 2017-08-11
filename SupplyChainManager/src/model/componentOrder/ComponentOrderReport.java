package model.componentOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.ComponentOrderReportRepository;

@DatabaseTable(tableName = "OrderReport")
public class ComponentOrderReport extends OrderReport {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ComponentOrder order;

    public ComponentOrderReport() {
    }  // empty constructor required by ORMLite

    public ComponentOrderReport(ComponentOrder componentOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = componentOrder;
        ComponentOrderReportRepository.getInstance().create(this);
    }

    public ComponentOrder getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
