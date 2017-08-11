package controller.componentOrder;

import model.componentOrder.ComponentOrder;
import model.product.Component;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;
import model.repository.ComponentRepository;
import model.repository.SupplierRepository;
import view.componentOrder.ComponentSelectionView;
import view.componentOrder.SetSupplierPropertiesView;
import view.componentOrder.SupplierSelectionForNewView;

import java.util.ArrayList;
import java.util.List;

public class ComponentOrderController {
    public static void startNewComponentOrder(ArrayList<Object> data) {
        new ComponentSelectionView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void componentSelectionCancel(ArrayList<Object> data) {
    }

    public static void componentSelectionNext(ArrayList<Object> data) {
        Component component = (Component) data.get(0);
        List<Supplier> suppliers = SupplierRepository.getInstance().filterByComponent(component);
        new SupplierSelectionForNewView(suppliers).setVisible(true);
    }

    public static void supplierSelectionForNewSubmit(ArrayList<Object> data) {
        Supplier supplier = (Supplier) data.get(0);
        if (supplier == null) {
            System.err.println("No supplier");
            return;
        }
        ComponentOrderRepository.getInstance().save(new ComponentOrder(supplier));
    }

    public static void supplierSelectionForNewCancel(ArrayList<Object> data) {
    }

    public static void startSetSupplierProperties(ArrayList<Object> data) {
        new SetSupplierPropertiesView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void setSupplierPropertiesSubmit(ArrayList<Object> data) {
        Component component = (Component) data.get(0);
        String name = (String) data.get(1);
        if (name.trim().equals("")) {
            System.err.println("Empty name is not allowd");
            return;
        }
        int price = (int) data.get(2);
        Supplier newSupplier = new Supplier(name, price, component);
        SupplierRepository.getInstance().save(newSupplier);
    }

    public static void setSupplierPropertiesCancel(ArrayList<Object> data) {
    }
}
