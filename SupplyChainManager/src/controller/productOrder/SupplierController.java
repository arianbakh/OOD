package controller.productOrder;

import java.util.ArrayList;

import model.repository.SupplierRepository;
import view.productOrder.SupplierListView;

public class SupplierController {
    public static void startGetSuppliers(ArrayList<Object> data) {
    	new SupplierListView(SupplierRepository.getInstance().getAll()).setVisible(true);
    }

    public static void suppliersListReturn(ArrayList<Object> data) {
    }
}
