package model.repository;

import java.util.List;

import model.componentOrder.ComponentOrder;

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
    
    public List<ComponentOrder> getIncomplete(){
    	return null;
    }
}
