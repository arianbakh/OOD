import controller.FrontController;
import model.product.Component;
import model.product.Product;
import model.productOrder.Supplier;
import model.repository.ComponentRepository;
import model.repository.ProductRepository;
import model.repository.SupplierRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        addDummyObjects();
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
    }
}
