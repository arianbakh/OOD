package model.order;

import com.j256.ormlite.field.DatabaseField;
import model.ModelBase;

import java.util.Date;

public abstract class OrderReport extends ModelBase {
    @DatabaseField
    private Date readyTime;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Person responsiblePerson;

    protected OrderReport() {
        this.readyTime = new Date();  // set to current time
    }  // empty constructor required by ORMLite

    protected OrderReport(Person responsiblePerson) {
        this.readyTime = new Date();  // set to current time
        this.responsiblePerson = responsiblePerson;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    protected void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
}
