package model.repository;

import model.customerOrder.CustomerOrderReport;

public class CustomerOrderReportRepository extends Repository<CustomerOrderReport> {
    private static CustomerOrderReportRepository customerOrderReportRepository;

    private CustomerOrderReportRepository() {
    }

    public static CustomerOrderReportRepository getInstance() {
        if (customerOrderReportRepository == null) {
            customerOrderReportRepository = new CustomerOrderReportRepository();
        }
        return customerOrderReportRepository;
    }
}
