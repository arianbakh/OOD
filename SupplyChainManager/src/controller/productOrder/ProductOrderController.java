package controller.productOrder;

import java.util.ArrayList;

import model.product.Component;
import model.product.ComponentManager;
import model.product.Product;
import model.product.ProductManager;
import view.SubmitCustomerOrderFrame;

public class ProductOrderController {
	public static void newProductOrder(ArrayList<Object> data) {
		ArrayList<Component> components = ComponentManager.getComponentManager().getAll();
		new SubmitCustomerOrderFrame(components).setVisible(true);
	}
}
