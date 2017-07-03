package controller.product;

import java.util.ArrayList;

import database.DataBase;
import model.product.Component;
import model.product.ComponentManager;
import view.ComponentsListFrame;

public class ComponentController {
	public static void listComponents(ArrayList<Object> data) {
        ArrayList<Component> components = ComponentManager.getComponentManager().getAll();
    	new ComponentsListFrame(components).setVisible(true);
	}
}
