package controller.product;

import model.product.Component;
import model.repository.ComponentRepository;
import view.product.ComponentsListView;
import view.product.NewComponentView;

import java.util.ArrayList;

public class ComponentController {
    public static void startShowExistingComponents(ArrayList<Object> data) {
        new ComponentsListView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void componentsListReturn(ArrayList<Object> data) {
    }

    public static void startNewComponent(ArrayList<Object> data) {
        new NewComponentView().setVisible(true);
    }

    public static void newComponentSubmit(ArrayList<Object> data) {
        String componentName = (String) data.get(0);
        if (componentName.trim().equals("")) {
            System.err.println("No name for component is provided");
            return;
        }
        ArrayList<Component> componentIfAny = ComponentRepository.getInstance().filter(componentName);
        if (componentIfAny.size() == 0) {
            new Component(componentName);
        } else {
            System.err.println("Component with same name already exists");
            return;
        }
    }

    public static void newComponentCancel(ArrayList<Object> data) {
    }
}
