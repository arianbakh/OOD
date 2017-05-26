import db.Component;
import db.DataBase;
import db.Person;
import db.Product;
import logic.CheckStock;
import ui.MainFrame;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
	    createDummyObjects();

        Timer timer = new Timer();
        timer.schedule(new CheckStock(), 0, TimeUnit.MINUTES.toMillis(1));

		EventQueue.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
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
