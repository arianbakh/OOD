package model.repository;

import model.customerOrder.CustomerOrder;
import model.product.Product;

import java.util.ArrayList;

public class CustomerOrderRepository extends Repository<CustomerOrder> {
    private static CustomerOrderRepository customerOrderRepository;

    private CustomerOrderRepository() {
    }

    public static CustomerOrderRepository getInstance() {
        if (customerOrderRepository == null) {
            customerOrderRepository = new CustomerOrderRepository();
        }
        return customerOrderRepository;
    }

    public ArrayList<CustomerOrder> getByProduct(Product product) {
        ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
        for (CustomerOrder customerOrder : getAll()) {
            if (customerOrder.getProduct() == product) {
                customerOrders.add(customerOrder);
            }
        }
        return customerOrders;
    }
}
