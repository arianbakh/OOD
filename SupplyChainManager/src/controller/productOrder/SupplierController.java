package controller.productOrder;

import model.repository.SupplierRepository;
import view.productOrder.SupplierListView;

import java.util.ArrayList;

public class SupplierController {
    public static void startGetSuppliers(ArrayList<Object> data) {
        new SupplierListView(SupplierRepository.getInstance().getAll()).setVisible(true);
    }

    public static void suppliersListReturn(ArrayList<Object> data) {
    }
}
