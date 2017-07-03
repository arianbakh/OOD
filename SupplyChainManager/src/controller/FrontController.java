package controller;
import java.awt.EventQueue;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import view.MainFrame;

public class FrontController {
	private static FrontController frontController;
	private Map<String, Method> controllersMap = new HashMap<String, Method>();

	private FrontController() {
		try {
			this.controllersMap.put("newProductOrder",
					controller.productOrder.ProductOrderController.class.getMethod("newProductOrder", ArrayList.class));
			this.controllersMap.put("listComponents",
					controller.product.ComponentController.class.getMethod("listComponents", ArrayList.class));
			this.controllersMap.put("newCustomerOrder",
					controller.customerOrder.CustomerOrderController.class.getMethod("newCustomerOrder", ArrayList.class));
			this.controllersMap.put("newProductOrderReport",
					controller.productOrder.ProductOrderReportController.class.getMethod("newproductOrderReport", ArrayList.class));
			this.controllersMap.put("newProductOrderReportDialogue",
					controller.productOrder.ProductOrderReportController.class.getMethod("newproductOrderReportDialogue", ArrayList.class));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	public static FrontController getFrontController() {
		if (frontController == null)
			frontController = new FrontController();
		return frontController;
	}

	public void homepage() {
		EventQueue.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
	}

	public void callController(String event, ArrayList<Object> data) {
		try {
			Method method = this.controllersMap.get(event);
			method.invoke(null, data);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
