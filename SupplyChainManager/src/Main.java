import controller.FrontController;
import model.product.Component;
import model.product.Product;
import model.repository.ComponentRepository;
import model.repository.ProductRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        addDummyObjects();
        FrontController.getFrontController().start();
    }

    private static void addDummyObjects() {
        Component component1 = new Component("مولفه ۱");
        ComponentRepository.getInstance().save(component1);

        Component component2 = new Component("مولفه ۲");
        ComponentRepository.getInstance().save(component2);

        ArrayList<Component> components = new ArrayList<>();
        components.add(component1);
        components.add(component2);

        Product product = new Product("محصول ۱", components);
        ProductRepository.getInstance().save(product);
    }
}
