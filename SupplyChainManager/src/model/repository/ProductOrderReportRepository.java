package model.repository;

import model.productOrder.ProductOrderReport;

public class ProductOrderReportRepository extends Repository<ProductOrderReport> {
    private static ProductOrderReportRepository productOrderReportRepository;

    private ProductOrderReportRepository() {
    }

    public static ProductOrderReportRepository getInstance() {
        if (productOrderReportRepository == null) {
            productOrderReportRepository = new ProductOrderReportRepository();
        }
        return productOrderReportRepository;
    }
}
