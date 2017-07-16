package model.repository;

import model.componentOrder.ComponentOrderReport;

public class ComponentOrderReportRepository extends Repository<ComponentOrderReport> {
    private static ComponentOrderReportRepository componentOrderReportRepository;

    private ComponentOrderReportRepository() {
    }

    public static ComponentOrderReportRepository getInstance() {
        if (componentOrderReportRepository == null) {
            componentOrderReportRepository = new ComponentOrderReportRepository();
        }
        return componentOrderReportRepository;
    }
}
