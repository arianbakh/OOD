package model.repository;

import model.customerOrder.Deliverer;

public class DelivererRepository extends Repository<Deliverer> {
    private static DelivererRepository delivererRepository;

    private DelivererRepository() {
    }

    public static DelivererRepository getInstance() {
        if (delivererRepository == null) {
            delivererRepository = new DelivererRepository();
        }
        return delivererRepository;
    }
}
