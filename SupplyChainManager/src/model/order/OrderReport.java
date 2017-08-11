package model.order;

import model.ModelBase;

import java.util.Date;

public abstract class OrderReport extends ModelBase {
    protected Order order;
    private Date readyTime;
    private Person responsiblePerson;

    protected OrderReport() {
    }  // empty constructor required by ORMLite

    protected OrderReport(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Order getOrder() {
        return order;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }
}
