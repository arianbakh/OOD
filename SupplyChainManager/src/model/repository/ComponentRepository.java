package model.repository;

import java.util.ArrayList;

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
    
    public ArrayList<Component> filter(String name){
    	ArrayList<Component> components = new ArrayList<>();
    	for (Component c: this.getAll())
    		if (c.getName().equals(name))
    			components.add(c);
    	return components;
    }
}
