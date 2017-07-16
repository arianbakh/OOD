package model.repository;

import model.product.Component;

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
}
