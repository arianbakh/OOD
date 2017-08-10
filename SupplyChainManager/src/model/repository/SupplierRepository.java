package model.repository;

import model.product.Component;
import model.productOrder.Supplier;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierRepository extends Repository<Supplier> {
    private static SupplierRepository supplierRepository;

    private SupplierRepository() {
    }

    public static SupplierRepository getInstance() {
        if (supplierRepository == null) {
            supplierRepository = new SupplierRepository();
        }
        return supplierRepository;
    }

    public List<Supplier> filterByComponent(Component component) {
        try {
            Map<String, Object> queryFields = new HashMap<>();
            queryFields.put("component_id", component);
            return getDao().queryForFieldValues(queryFields);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
