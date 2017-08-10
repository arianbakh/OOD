import controller.FrontController;

import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.order.Person;
import model.customerOrder.CustomerOrder;
import model.customerOrder.CustomerOrderReport;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.product.ProductComponent;
import model.product.StockChecker;
import model.productOrder.ProductOrder;
import model.productOrder.ProductOrderReport;
import model.productOrder.ProductOrderSupplier;
import model.productOrder.Supplier;
import model.productReview.ProductFormReview;
import model.productReview.ProductTextReview;
import model.repository.ComponentOrderRepository;
import model.repository.ComponentRepository;
import model.repository.CustomerOrderRepository;
import model.repository.DatabaseHelper;
import model.repository.DelivererRepository;
import model.repository.PersonRepository;
import model.repository.ProductOrderRepository;
import model.repository.ProductRepository;
import model.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {
    public static void main(String[] args) {
        initializeDatabase();
        addDummyObjects();
        Timer timer = new Timer();
        timer.schedule(new StockChecker(), 0, TimeUnit.SECONDS.toMillis(30));
        FrontController.getFrontController().start();
    }

    private static void initializeDatabase() {
        try {
            ConnectionSource connectionSource = DatabaseHelper.getConnectionSource();

            TableUtils.createTableIfNotExists(connectionSource, Component.class);
            TableUtils.clearTable(connectionSource, Component.class);
            TableUtils.createTableIfNotExists(connectionSource, Supplier.class);
            TableUtils.clearTable(connectionSource, Supplier.class);
            TableUtils.createTableIfNotExists(connectionSource, Person.class);
            TableUtils.clearTable(connectionSource, Person.class);
            TableUtils.createTableIfNotExists(connectionSource, ComponentOrder.class);
            TableUtils.clearTable(connectionSource, ComponentOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, ComponentOrderReport.class);
            TableUtils.clearTable(connectionSource, ComponentOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, Deliverer.class);
            TableUtils.clearTable(connectionSource, Deliverer.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
            TableUtils.clearTable(connectionSource, Product.class);
            TableUtils.createTableIfNotExists(connectionSource, CustomerOrder.class);
            TableUtils.clearTable(connectionSource, CustomerOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, CustomerOrderReport.class);
            TableUtils.clearTable(connectionSource, CustomerOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrder.class);
            TableUtils.clearTable(connectionSource, ProductOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrderReport.class);
            TableUtils.clearTable(connectionSource, ProductOrderReport.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductFormReview.class);
            TableUtils.clearTable(connectionSource, ProductFormReview.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductTextReview.class);
            TableUtils.clearTable(connectionSource, ProductTextReview.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductComponent.class);
            TableUtils.clearTable(connectionSource, ProductComponent.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductOrderSupplier.class);
            TableUtils.clearTable(connectionSource, ProductOrderSupplier.class);

            Component component = new Component("RAM");
            Dao<Component, Integer> componentDao = DaoManager.createDao(connectionSource, Component.class);
            componentDao.create(component);
            System.out.println("###" + componentDao.queryForAll());

            Supplier supplier = new Supplier("ASUS_RAM", 1000, component);
            Dao<Supplier, Integer> supplierDao = DaoManager.createDao(connectionSource, Supplier.class);
            supplierDao.create(supplier);
            System.out.println("###" + supplierDao.queryForAll());
            System.out.println("###" + supplierDao.queryForAll().get(0).getComponent());
            System.out.println("###" + componentDao.queryForAll().get(0).getSuppliers().get(0));

            Person person = new Person("John");
            Dao<Person, Integer> personDao = DaoManager.createDao(connectionSource, Person.class);
            personDao.create(person);
            System.out.println("###" + personDao.queryForAll());

            ComponentOrder componentOrder = new ComponentOrder(supplier);
            Dao<ComponentOrder, Integer> componentOrderDao = DaoManager.createDao(connectionSource, ComponentOrder.class);
            componentOrderDao.create(componentOrder);
            System.out.println("###" + componentOrderDao.queryForAll());

            ComponentOrderReport componentOrderReport = new ComponentOrderReport(componentOrder, person);
            Dao<ComponentOrderReport, Integer> componentOrderReportDao = DaoManager.createDao(connectionSource, ComponentOrderReport.class);
            componentOrderReportDao.create(componentOrderReport);
            System.out.println("###" + componentOrderReportDao.queryForAll());

            componentOrder.setReport(componentOrderReport);
            componentOrderDao.update(componentOrder);
            ComponentOrder retrievedComponentOrder = componentOrderDao.queryForAll().get(0);
            System.out.println("###" + componentOrder.getReport());
            System.out.println("###" + retrievedComponentOrder.getReport());
            System.out.println("###" + retrievedComponentOrder.getOrderTime());
            System.out.println("###" + retrievedComponentOrder.getReport().getReadyTime());

            Deliverer deliverer = new Deliverer("Jack", "very reliable");
            Dao<Deliverer, Integer> delivererDao = DaoManager.createDao(connectionSource, Deliverer.class);
            delivererDao.create(deliverer);
            System.out.println("###" + delivererDao.queryForAll());

            ArrayList<Component> components = new ArrayList<Component>(); // TODO replace with many to many
            components.add(component);
            Product product = new Product("PC", components);
            Dao<Product, Integer> productDao = DaoManager.createDao(connectionSource, Product.class);
            productDao.create(product);
            System.out.println("###" + productDao.queryForAll());

            CustomerOrder customerOrder = new CustomerOrder(product);
            Dao<CustomerOrder, Integer> customerOrderDao = DaoManager.createDao(connectionSource, CustomerOrder.class);
            customerOrderDao.create(customerOrder);
            System.out.println("###" + customerOrderDao.queryForAll());

            CustomerOrderReport customerOrderReport = new CustomerOrderReport(customerOrder, person);
            Dao<CustomerOrderReport, Integer> customerOrderReportDao = DaoManager.createDao(connectionSource, CustomerOrderReport.class);
            customerOrderReportDao.create(customerOrderReport);
            System.out.println("###" + customerOrderReportDao.queryForAll());

            customerOrder.setReport(customerOrderReport);
            customerOrderDao.update(customerOrder);
            CustomerOrder retrievedCustomerOrder = customerOrderDao.queryForAll().get(0);
            System.out.println("###" + customerOrder.getReport());
            System.out.println("###" + retrievedCustomerOrder.getReport());
            System.out.println("###" + retrievedCustomerOrder.getOrderTime());
            System.out.println("###" + retrievedCustomerOrder.getReport().getReadyTime());

            ProductOrder productOrder = new ProductOrder(product);
            Dao<ProductOrder, Integer> productOrderDao = DaoManager.createDao(connectionSource, ProductOrder.class);
            productOrderDao.create(productOrder);
            System.out.println("###" + productOrderDao.queryForAll());

            ProductOrderReport productOrderReport = new ProductOrderReport(productOrder, person);
            Dao<ProductOrderReport, Integer> productOrderReportDao = DaoManager.createDao(connectionSource, ProductOrderReport.class);
            productOrderReportDao.create(productOrderReport);
            System.out.println("###" + productOrderReportDao.queryForAll());

            productOrder.setReport(productOrderReport);
            productOrderDao.update(productOrder);
            ProductOrder retrievedProductOrder = productOrderDao.queryForAll().get(0);
            System.out.println("###" + productOrder.getReport());
            System.out.println("###" + retrievedProductOrder.getReport());
            System.out.println("###" + retrievedProductOrder.getOrderTime());
            System.out.println("###" + retrievedProductOrder.getReport().getReadyTime());

            ProductFormReview productFormReview = new ProductFormReview(5, 3, product);
            Dao<ProductFormReview, Integer> productFormReviewDao = DaoManager.createDao(connectionSource, ProductFormReview.class);
            productFormReviewDao.create(productFormReview);
            System.out.println("###" + productFormReviewDao.queryForAll());
            System.out.println("###" + productFormReviewDao.queryForAll().get(0).getQualityRating());

            ProductTextReview productTextReview = new ProductTextReview(product, "fucking horrible");
            Dao<ProductTextReview, Integer> productTextReviewDao = DaoManager.createDao(connectionSource, ProductTextReview.class);
            productTextReviewDao.create(productTextReview);
            System.out.println("###" + productTextReviewDao.queryForAll());

            ProductComponent productComponent = new ProductComponent(product, component);
            Dao<ProductComponent, Integer> productComponentDao = DaoManager.createDao(connectionSource, ProductComponent.class);
            productComponentDao.create(productComponent);
            System.out.println("###" + productComponentDao.queryForAll());
            System.out.println("###" + productComponentDao.queryForAll().get(0).getProduct());
            System.out.println("###" + productComponentDao.queryForAll().get(0).getComponent());

            ProductOrderSupplier productOrderSupplier = new ProductOrderSupplier(productOrder, supplier);
            Dao<ProductOrderSupplier, Integer> productOrderSupplierDao = DaoManager.createDao(connectionSource, ProductOrderSupplier.class);
            productOrderSupplierDao.create(productOrderSupplier);
            System.out.println("###" + productOrderSupplierDao.queryForAll());
            System.out.println("###" + productOrderSupplierDao.queryForAll().get(0).getProductOrder());
            System.out.println("###" + productOrderSupplierDao.queryForAll().get(0).getSupplier());
        } catch (Exception e) {
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           System.exit(0);
        }
    }

    private static void addDummyObjects() {
        Component ramComponent = new Component("RAM");
        ComponentRepository.getInstance().save(ramComponent);

        Supplier ramSupplier1 = new Supplier("Huawei RAM", 100, ramComponent);
        SupplierRepository.getInstance().save(ramSupplier1);
        ramComponent.addSupplier(ramSupplier1);

        Supplier ramSupplier2 = new Supplier("ASUS RAM", 200, ramComponent);
        SupplierRepository.getInstance().save(ramSupplier2);
        ramComponent.addSupplier(ramSupplier2);

        Supplier ramSupplier3 = new Supplier("Kingston RAM", 300, ramComponent);
        SupplierRepository.getInstance().save(ramSupplier3);
        ramComponent.addSupplier(ramSupplier3);

        Component gpuComponent = new Component("GPU");
        ComponentRepository.getInstance().save(gpuComponent);

        Supplier gpuSupplier1 = new Supplier("NVidia GPU", 1000, gpuComponent);
        SupplierRepository.getInstance().save(gpuSupplier1);
        gpuComponent.addSupplier(gpuSupplier1);

        Supplier gpuSupplier2 = new Supplier("AMD GPU", 2000, gpuComponent);
        SupplierRepository.getInstance().save(gpuSupplier2);
        gpuComponent.addSupplier(gpuSupplier2);

        Supplier gpuSupplier3 = new Supplier("Intel GPU", 3000, gpuComponent);
        SupplierRepository.getInstance().save(gpuSupplier3);
        gpuComponent.addSupplier(gpuSupplier3);

        Component ssdComponent = new Component("SSD");
        ComponentRepository.getInstance().save(ssdComponent);

        Supplier ssdSupplier1 = new Supplier("Samsung SSD", 10, ssdComponent);
        SupplierRepository.getInstance().save(ssdSupplier1);
        ssdComponent.addSupplier(ssdSupplier1);

        Supplier ssdSupplier2 = new Supplier("ADATA SSD", 20, ssdComponent);
        SupplierRepository.getInstance().save(ssdSupplier2);
        ssdComponent.addSupplier(ssdSupplier2);

        Component hddComponent = new Component("HDD");
        ComponentRepository.getInstance().save(hddComponent);

        Supplier hddSupplier1 = new Supplier("Silicon Power HDD", 1, hddComponent);
        SupplierRepository.getInstance().save(hddSupplier1);
        hddComponent.addSupplier(hddSupplier1);

        Supplier hddSupplier2 = new Supplier("Western Digital HDD", 2, hddComponent);
        SupplierRepository.getInstance().save(hddSupplier2);
        hddComponent.addSupplier(hddSupplier2);

        Component cpuComponent = new Component("CPU");
        ComponentRepository.getInstance().save(cpuComponent);

        Supplier cpuSupplier1 = new Supplier("Intel CPU", 10000, cpuComponent);
        SupplierRepository.getInstance().save(cpuSupplier1);
        cpuComponent.addSupplier(cpuSupplier1);

        Supplier cpuSupplier2 = new Supplier("AMD CPU", 20000, cpuComponent);
        SupplierRepository.getInstance().save(cpuSupplier2);
        cpuComponent.addSupplier(cpuSupplier2);

        ArrayList<Component> businessPcComponents = new ArrayList<>();
        businessPcComponents.add(ramComponent);
        businessPcComponents.add(hddComponent);
        businessPcComponents.add(cpuComponent);
        Product businessPc = new Product("Business PC", businessPcComponents);
        businessPc.setCurrentStock(5);
        ProductRepository.getInstance().save(businessPc);

        ArrayList<Component> gamingPcComponents = new ArrayList<>();
        gamingPcComponents.add(ramComponent);
        gamingPcComponents.add(ssdComponent);
        gamingPcComponents.add(cpuComponent);
        gamingPcComponents.add(gpuComponent);
        Product gamingPc = new Product("Gaming PC", gamingPcComponents);
        gamingPc.setCurrentStock(10);
        ProductRepository.getInstance().save(gamingPc);
        
        Deliverer tnt = new Deliverer("TNT", "Very Fast");
        DelivererRepository.getInstance().save(tnt);
        Deliverer fedex = new Deliverer("Fedex", "Very Slow");
        DelivererRepository.getInstance().save(fedex);
        Deliverer dhl = new Deliverer("DHL", "Very Safe");
        DelivererRepository.getInstance().save(dhl);

        Person person1 = new Person("John Smith");
        PersonRepository.getInstance().save(person1);
        Person person2 = new Person("Jane Doe");
        PersonRepository.getInstance().save(person2);
        Person person3 = new Person("Jim Jarmush");
        PersonRepository.getInstance().save(person3);

        CustomerOrder customerOrder = new CustomerOrder(gamingPc);
        CustomerOrderRepository.getInstance().save(customerOrder);
        
        ComponentOrder componentOrder = new ComponentOrder(cpuComponent.getSuppliers().get(0));
        ComponentOrderRepository.getInstance().save(componentOrder);

        ProductOrder productOrder = new ProductOrder(businessPc);
        ArrayList<Supplier> productOrderSuppliers = new ArrayList<>();
        productOrderSuppliers.add(ramSupplier1);
        productOrderSuppliers.add(ssdSupplier1);
        productOrderSuppliers.add(cpuSupplier1);
        productOrderSuppliers.add(gpuSupplier1);
        productOrder.setSuppliers(productOrderSuppliers);
        ProductOrderRepository.getInstance().save(productOrder);
    }
}
