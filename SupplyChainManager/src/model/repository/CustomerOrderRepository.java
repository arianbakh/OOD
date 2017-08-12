package model.repository;

import model.customerOrder.CustomerOrder;
import model.product.Product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerOrderRepository extends Repository<CustomerOrder> {
    private static CustomerOrderRepository customerOrderRepository;

    private CustomerOrderRepository() {
    }

    public static CustomerOrderRepository getInstance() {
        if (customerOrderRepository == null) {
            customerOrderRepository = new CustomerOrderRepository();
        }
        return customerOrderRepository;
    }

    public List<CustomerOrder> getByProduct(Product product) {
        try {
            Map<String, Object> queryFields = new HashMap<>();
            queryFields.put("product_id", product);
            return getDao().queryForFieldValues(queryFields);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public List<CustomerOrder> getIncomplete() {
        try {
            return getDao().queryBuilder().where().isNull("report_id").query();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
