import controller.FrontController;
import model.componentOrder.ComponentOrder;
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
import model.repository.ProductRepository;
import model.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        addDummyObjects();
        Timer timer = new Timer();
        timer.schedule(new StockChecker(), 0, TimeUnit.MINUTES.toMillis(1));
        FrontController.getFrontController().start();
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
    }
}
