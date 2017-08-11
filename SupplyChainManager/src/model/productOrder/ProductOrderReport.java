package model.productOrder;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import model.order.OrderReport;
import model.order.Person;
import model.repository.ProductOrderReportRepository;

@DatabaseTable(tableName = "ProductOrderReport")
public class ProductOrderReport extends OrderReport {
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private ProductOrder order;

    public ProductOrderReport() {
    }  // empty constructor required by ORMLite

    public ProductOrderReport(ProductOrder productOrder, Person responsiblePerson) {
        super(responsiblePerson);
        this.order = productOrder;
        ProductOrderReportRepository.getInstance().create(this);
    }

    public void setResponsiblePerson(Person person) {
        super.setResponsiblePerson(person);
        ProductOrderReportRepository.getInstance().save(this);
    }

    @Override
    public String toString() {
        return "ProductOrderReport";
    }
}
