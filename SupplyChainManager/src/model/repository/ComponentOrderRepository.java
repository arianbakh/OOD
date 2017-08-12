package model.repository;

import model.componentOrder.ComponentOrder;

import java.sql.SQLException;
import java.util.List;

public class ComponentOrderRepository extends Repository<ComponentOrder> {
    private static ComponentOrderRepository componentOrderRepository;

    private ComponentOrderRepository() {
    }

    public static ComponentOrderRepository getInstance() {
        if (componentOrderRepository == null) {
            componentOrderRepository = new ComponentOrderRepository();
        }
        return componentOrderRepository;
    }

    public List<ComponentOrder> getIncomplete() {
        try {
            return getDao().queryBuilder().where().isNull("report_id").query();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
