package model.repository;

import model.product.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentRepository extends Repository<Component> {
    private static ComponentRepository componentRepository;

    private ComponentRepository() {
    }

    public static ComponentRepository getInstance() {
        if (componentRepository == null) {
            componentRepository = new ComponentRepository();
        }
        return componentRepository;
    }

    public List<Component> filter(String name) {
        try {
            Map<String, Object> queryFields = new HashMap<>();
            queryFields.put("name", name);
            return getDao().queryForFieldValues(queryFields);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
