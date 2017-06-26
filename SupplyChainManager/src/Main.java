import logic.CheckStock;
import model.order.Person;
import model.product.Component;
import model.product.Product;
import view.MainFrame;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import controller.FrontController;
import database.DataBase;

public class Main {
	public static void main(String[] args) {
	    createDummyObjects();

        Timer timer = new Timer();
        timer.schedule(new CheckStock(), 0, TimeUnit.MINUTES.toMillis(1));
        FrontController.getFrontController().homepage();
	}

	private static void createDummyObjects() {
        Component component = new Component("مولفه الف");
        Component component2 = new Component("مولفه ب");
        DataBase.getDB().addComponent(component);
        DataBase.getDB().addComponent(component2);
        ArrayList<Component> productComponents = new ArrayList<>();
        productComponents.add(component);
        DataBase.getDB().addProduct(new Product("محصول الف", productComponents, 0, 10));
        ArrayList<Component> productComponents2 = new ArrayList<>();
        productComponents2.add(component);
        productComponents2.add(component2);
        DataBase.getDB().addProduct(new Product("محصول ب", productComponents2, 2, 5));
        DataBase.getDB().addPerson(new Person("کارمند الف"));
        DataBase.getDB().addPerson(new Person("کارمند ب"));
    }
}
