import controller.FrontController;

import model.componentOrder.ComponentOrder;
import model.componentOrder.ComponentOrderReport;
import model.order.Person;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.product.StockChecker;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;
import model.repository.ComponentRepository;
import model.repository.CustomerOrderRepository;
import model.repository.DelivererRepository;
import model.repository.PersonRepository;
import model.repository.ProductRepository;
import model.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {
    public static void main(String[] args) {
        initializeDatabase();
        addDummyObjects();
        Timer timer = new Timer();
        timer.schedule(new StockChecker(), 0, TimeUnit.MINUTES.toMillis(1));
        FrontController.getFrontController().start();
    }

    private static void initializeDatabase() {
        try {
            String databaseUrl = "jdbc:sqlite:main.db";
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            TableUtils.createTableIfNotExists(connectionSource, Component.class);
            TableUtils.clearTable(connectionSource, Component.class);
            Component component = new Component("RAM");
            Dao<Component, String> componentDao = DaoManager.createDao(connectionSource, Component.class);
            componentDao.create(component);
            System.out.println(componentDao.queryForAll());

            TableUtils.createTableIfNotExists(connectionSource, Supplier.class);
            TableUtils.clearTable(connectionSource, Supplier.class);
            Supplier supplier = new Supplier("ASUS_RAM", 1000, component);
            Dao<Supplier, String> supplierDao = DaoManager.createDao(connectionSource, Supplier.class);
            supplierDao.create(supplier);
            System.out.println(supplierDao.queryForAll());
            System.out.println(supplierDao.queryForAll().get(0).getComponent());

            TableUtils.createTableIfNotExists(connectionSource, Person.class);
            TableUtils.clearTable(connectionSource, Person.class);
            Person person = new Person("John");
            Dao<Person, String> personDao = DaoManager.createDao(connectionSource, Person.class);
            personDao.create(person);
            System.out.println(personDao.queryForAll());

            TableUtils.createTableIfNotExists(connectionSource, ComponentOrder.class);
            TableUtils.clearTable(connectionSource, ComponentOrder.class);
            ComponentOrder componentOrder = new ComponentOrder(supplier);
            Dao<ComponentOrder, Integer> componentOrderDao = DaoManager.createDao(connectionSource, ComponentOrder.class);
            componentOrderDao.create(componentOrder);
            System.out.println(componentOrderDao.queryForAll());

            TableUtils.createTableIfNotExists(connectionSource, ComponentOrderReport.class);
            TableUtils.clearTable(connectionSource, ComponentOrderReport.class);
            ComponentOrderReport componentOrderReport = new ComponentOrderReport(componentOrder, person);
            Dao<ComponentOrderReport, Integer> componentOrderReportDao = DaoManager.createDao(connectionSource, ComponentOrderReport.class);
            componentOrderReportDao.create(componentOrderReport);
            System.out.println(componentOrderReportDao.queryForAll());

            componentOrder.setReport(componentOrderReport);
            componentOrderDao.update(componentOrder);
            ComponentOrder retrieved = componentOrderDao.queryForAll().get(0);
            System.out.println(componentOrder.getReport());
            System.out.println(retrieved.getReport());
            System.out.println(retrieved.getOrderTime());
            System.out.println(retrieved.getReport().getReadyTime());
        } catch (Exception e) {
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           System.exit(0);
        }
    }

    private static void addDummyObjects() {
        Component component1 = new Component("مولفه ۱");
        ComponentRepository.getInstance().save(component1);

        component1.addSupplier("تامین‌کننده ۱", 1000);
        component1.addSupplier("تامین‌کننده ۲", 2000);

        Component component2 = new Component("مولفه ۲");
        ComponentRepository.getInstance().save(component2);

        component2.addSupplier("تامین‌کننده ۳", 3000);

        ArrayList<Component> components = new ArrayList<>();
        components.add(component1);
        components.add(component2);

        Product product = new Product("محصول ۱", components);
        product.setCurrentStock(5);
        ProductRepository.getInstance().save(product);

        Product product2 = new Product("محصول ۲", components);
        product2.setCurrentStock(10);
        ProductRepository.getInstance().save(product2);
        
        CustomerOrder co = new CustomerOrder(product);
        CustomerOrderRepository.getInstance().save(co);
        
        Deliverer del = new Deliverer("تحویل دهنده‌ی ۱", "ویژگی ۱");
        DelivererRepository.getInstance().save(del);
        
        ComponentOrder componentOrder = new ComponentOrder(component1.getSuppliers().get(0));
        ComponentOrderRepository.getInstance().save(componentOrder);
        
        Supplier supplier1 = new Supplier("تامین‌کننده ۱", 1000, component1);
        SupplierRepository.getInstance().save(supplier1);
        
        Person person1 = new Person("غلام");
        PersonRepository.getInstance().save(person1);
    }
}
