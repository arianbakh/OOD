package model.order;

public abstract class OrderReport {
    protected Order order;
    private Time readyTime;
    private Person responsiblePerson;

    protected OrderReport(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Order getOrder() {
        return order;
    }

    public Time getReadyTime() {
        return readyTime;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }
}
