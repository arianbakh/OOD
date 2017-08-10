package controller.product;

import model.product.Component;
import model.product.Product;
import model.repository.ComponentRepository;
import model.repository.ProductRepository;
import view.product.*;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public static void startSetProductStock(ArrayList<Object> data) {
        List<Product> products = ProductRepository.getInstance().getAll();
        new SelectProductMinMaxView(products).setVisible(true);
        ;
    }

    public static void selectProductMinMaxCancel(ArrayList<Object> data) {
    }

    public static void selectProductMinMaxSubmit(ArrayList<Object> data) {
        Product product = (Product) data.get(0);
        int min = (int) data.get(1);
        int max = (int) data.get(2);
        if (min > max)
            min = max;
        product.setMinStock(min);
        product.setMaxStock(max);
    }

    public static void startViewStock(ArrayList<Object> data) {
        List<Product> products = ProductRepository.getInstance().getAll();
        new StockCheckView(products).setVisible(true);
    }

    public static void stockCheckReturn(ArrayList<Object> data) {
    }

    public static void startFilterProducts(ArrayList<Object> data) {
        new SelectComponentsView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void selectComponentsCancel(ArrayList<Object> data) {
    }

    public static void selectComponentsNext(ArrayList<Object> data) {
        ArrayList<Component> components = new ArrayList<>();
        for (Object c : (Object[]) data.get(0))
            components.add((Component) c);
        ArrayList<Product> familiarProducts = ProductRepository.getInstance().hasAll(components);
        new ShowFamiliarsView(familiarProducts).setVisible(true);
        ;
    }

    public static void productListReturn(ArrayList<Object> data) {
    }

    public static void startNewProduct(ArrayList<Object> data) {
        new NewProductView(ComponentRepository.getInstance().getAll()).setVisible(true);
    }

    public static void newProductSubmit(ArrayList<Object> data) {
        ArrayList<Component> components = new ArrayList<>();
        for (Object c : (Object[]) data.get(0))
            components.add((Component) c);
        if (components.size() == 0) {
            System.err.println("ٔNo component was selected");
            return;
        }
        String productName = (String) data.get(1);

        ArrayList<Product> productsIfAny = ProductRepository.getInstance().filter(components);
        if (productsIfAny.size() == 0) {
            Product product = new Product(productName, components);
            ProductRepository.getInstance().save(product);
        } else {
            System.err.println("Product already exists");
        }

    }

    public static void newProductCancel(ArrayList<Object> data) {

    }
}
