import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import controller.FrontController;
import controller.productOrder.StockChecker;
import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.customerOrder.Deliverer;
import model.order.Person;
import model.product.Component;
import model.product.Product;
import model.product.ProductComponent;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderReport;
import model.productOrder.ProductOrderSupplier;
import model.productOrder.Supplier;
import model.productReview.ProductFormReview;
import model.productReview.ProductTextReview;
import model.repository.DatabaseHelper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        initializeDatabase();
        addDummyObjects();
        Timer timer = new Timer();
        timer.schedule(new StockChecker(), 0, TimeUnit.SECONDS.toMillis(5));
        FrontController.getFrontController().start();
    }

    private static void initializeDatabase() {
        try {
            ConnectionSource connectionSource = DatabaseHelper.getConnectionSource();

            TableUtils.createTableIfNotExists(connectionSource, Component.class);
            TableUtils.createTableIfNotExists(connectionSource, Supplier.class);
            TableUtils.createTableIfNotExists(connectionSource, Person.class);
            TableUtils.createTableIfNotExists(connectionSource, ComponentOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, ComponentOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, Deliverer.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
            TableUtils.createTableIfNotExists(connectionSource, CustomerOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, CustomerOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductFormReview.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductTextReview.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductComponent.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrderSupplier.class);

            TableUtils.clearTable(connectionSource, Component.class);
            TableUtils.clearTable(connectionSource, Supplier.class);
            TableUtils.clearTable(connectionSource, Person.class);
            TableUtils.clearTable(connectionSource, ComponentOrder.class);
            TableUtils.clearTable(connectionSource, ComponentOrderReport.class);
            TableUtils.clearTable(connectionSource, Deliverer.class);
            TableUtils.clearTable(connectionSource, Product.class);
            TableUtils.clearTable(connectionSource, CustomerOrder.class);
            TableUtils.clearTable(connectionSource, CustomerOrderReport.class);
            TableUtils.clearTable(connectionSource, ProductOrder.class);
            TableUtils.clearTable(connectionSource, ProductOrderReport.class);
            TableUtils.clearTable(connectionSource, ProductFormReview.class);
            TableUtils.clearTable(connectionSource, ProductTextReview.class);
            TableUtils.clearTable(connectionSource, ProductComponent.class);
            TableUtils.clearTable(connectionSource, ProductOrderSupplier.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void addDummyObjects() {
        Component ramComponent = new Component("RAM");
        Supplier ramSupplier = new Supplier("Huawei RAM", 100, ramComponent);
        new Supplier("ASUS RAM", 200, ramComponent);
        new Supplier("Kingston RAM", 300, ramComponent);

        Component gpuComponent = new Component("GPU");
        Supplier gpuSupplier = new Supplier("NVidia GPU", 1000, gpuComponent);
        new Supplier("AMD GPU", 2000, gpuComponent);
        new Supplier("Intel GPU", 3000, gpuComponent);

        Component ssdComponent = new Component("SSD");
        Supplier ssdSupplier = new Supplier("Samsung SSD", 10, ssdComponent);
        new Supplier("ADATA SSD", 20, ssdComponent);

        Component hddComponent = new Component("HDD");
        new Supplier("Silicon Power HDD", 1, hddComponent);
        new Supplier("Western Digital HDD", 2, hddComponent);

        Component cpuComponent = new Component("CPU");
        Supplier cpuSupplier = new Supplier("Intel CPU", 10000, cpuComponent);
        new Supplier("AMD CPU", 20000, cpuComponent);

        ArrayList<Component> businessPcComponents = new ArrayList<>();
        businessPcComponents.add(ramComponent);
        businessPcComponents.add(hddComponent);
        businessPcComponents.add(cpuComponent);
        Product businessPc = new Product("Business PC", businessPcComponents);
        businessPc.setCurrentStock(5);

        ArrayList<Component> gamingPcComponents = new ArrayList<>();
        gamingPcComponents.add(ramComponent);
        gamingPcComponents.add(ssdComponent);
        gamingPcComponents.add(cpuComponent);
        gamingPcComponents.add(gpuComponent);
        Product gamingPc = new Product("Gaming PC", gamingPcComponents);
        gamingPc.setCurrentStock(10);

        new Deliverer("TNT", "Very Fast");
        new Deliverer("Fedex", "Very Slow");
        new Deliverer("DHL", "Very Safe");

        new Person("John Smith");
        new Person("Jane Doe");
        new Person("Jim Jarmush");

        new CustomerOrder(gamingPc);

        new ComponentOrder((Supplier) cpuComponent.getSuppliers().toArray()[0]);

        ProductOrder productOrder = new ProductOrder(businessPc);
        ArrayList<Supplier> productOrderSuppliers = new ArrayList<>();
        productOrderSuppliers.add(ramSupplier);
        productOrderSuppliers.add(ssdSupplier);
        productOrderSuppliers.add(cpuSupplier);
        productOrderSuppliers.add(gpuSupplier);
        productOrder.setSuppliers(productOrderSuppliers);
    }
}
