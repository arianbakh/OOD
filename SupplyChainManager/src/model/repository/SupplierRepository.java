package model.repository;

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
}
