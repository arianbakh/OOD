package model.product;

import java.util.ArrayList;

import database.DataBase;

public class ComponentManager {
	private static ComponentManager componentManager;
	
	private ComponentManager(){
		
	}
	
	public static ComponentManager getComponentManager(){
		if (componentManager == null)
			componentManager = new ComponentManager();
		return componentManager;
	}
	
	public ArrayList<Component> getAll(){
		return DataBase.getDB().getComponents();
	}
	
}
