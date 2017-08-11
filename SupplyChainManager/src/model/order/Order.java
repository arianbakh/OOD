package model.order;

import com.j256.ormlite.field.DatabaseField;
import model.ModelBase;

import java.util.Date;

public abstract class Order extends ModelBase {
    @DatabaseField
    private Date orderTime;

    protected Order() {
        this.orderTime = new Date();  // set to current time
    }

    public Date getOrderTime() {
        return orderTime;
    }
}
