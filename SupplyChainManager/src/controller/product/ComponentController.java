package controller.product;

import model.product.Component;
import model.repository.ComponentRepository;
import view.product.ComponentsListView;

import java.util.ArrayList;

public class ComponentController {
    public static void startShowExistingComponents(ArrayList<Object> data) {
        new ComponentsListView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void componentsListReturn(ArrayList<Object> data) {
    }
}
