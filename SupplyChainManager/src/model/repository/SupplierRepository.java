package model.repository;

import java.util.ArrayList;

import model.product.Component;
import model.productOrder.Supplier;

public class SupplierRepository extends Repository<Supplier> {
    private static SupplierRepository supplierRepository;

    private SupplierRepository() {
    }

    public static SupplierRepository getInstance() {
        if (supplierRepository == null) {
            supplierRepository = new SupplierRepository();
        }
        return supplierRepository;
    }
    
    public static ArrayList<Supplier> filterByComponent(Component c){
    	ArrayList<Supplier> result = new ArrayList<>();
    	for (Supplier sup: supplierRepository.getAll()){
    		if (sup.getComponent() == c){
    			result.add(sup);
    		}
    	}
    	return result;
    }
}
