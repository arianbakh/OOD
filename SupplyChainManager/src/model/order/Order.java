package model.order;

import model.ModelBase;

import java.util.Date;

public abstract class Order extends ModelBase {
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
