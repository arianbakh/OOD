package model.order;

public abstract class Order {
    private Time orderTime;
    private OrderReport report;

    public Time getOrderTime() {
        return orderTime;
    }

    public OrderReport getReport() {
        return report;
    }

    public void submitReport(Person responsiblePerson) {
    }
}
