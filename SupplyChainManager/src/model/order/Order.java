package model.order;

import java.util.Date;

public abstract class Order {
    private Date orderTime;
    private OrderReport report;

    public Date getOrderTime() {
        return orderTime;
    }

    public OrderReport getReport() {
        return report;
    }

    public void submitReport(OrderReport report) {
        this.report = report;
    }
}
