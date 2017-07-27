package controller.componentOrder;

import model.componentOrder.ComponentOrder;
import model.product.Component;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;
import model.repository.ComponentRepository;
import view.componentOrder.ComponentSelectionView;
import view.componentOrder.SupplierSelectionForNewView;

import java.util.ArrayList;

public class ComponentOrderController {
    public static void startNewComponentOrder(ArrayList<Object> data) {
        new ComponentSelectionView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void componentSelectionCancel(ArrayList<Object> data) {
    }

    public static void componentSelectionNext(ArrayList<Object> data) {
        Component component = (Component)data.get(0);
        new SupplierSelectionForNewView(component.getSuppliers()).setVisible(true);
    }

    public static void supplierSelectionForNewCancel(ArrayList<Object> data) {
    }

    public static void supplierSelectionForNewSubmit(ArrayList<Object> data) {
        Supplier supplier = (Supplier)data.get(0);
        ComponentOrderRepository.getInstance().save(new ComponentOrder(supplier));
    }

    public static void startSelectSupplier(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForEditCancel(ArrayList<Object> data) {
    }

    public static void componentOrderSelectionForEditNext(ArrayList<Object> data) {
    }

    public static void supplierSelectionForEditCancel(ArrayList<Object> data) {
    }

    public static void supplierSelectionForEditSubmit(ArrayList<Object> data) {
    }
}
