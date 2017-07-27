package controller;

import view.FrontView;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private static FrontController frontController;
    private Map<String, Method> controllersMap = new HashMap<String, Method>();

    private FrontController() {
        try {
            this.controllersMap.put("startTextProductReview",
                    controller.productReview.ProductTextReviewController.class.getMethod("startNewTextProductReview", ArrayList.class));
            this.controllersMap.put("newTextReview",
                    controller.productReview.ProductTextReviewController.class.getMethod("submitFormSubmit", ArrayList.class));
            this.controllersMap.put("cancelTextReview",
                    controller.productReview.ProductTextReviewController.class.getMethod("submitFormCancel", ArrayList.class));
            this.controllersMap.put("showExistingComponents",
                    controller.product.ComponentController.class.getMethod("startShowExistingComponents", ArrayList.class));
            this.controllersMap.put("componentsListReturn",
                    controller.product.ComponentController.class.getMethod("componentsListReturn", ArrayList.class));
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static FrontController getFrontController() {
        if (frontController == null)
            frontController = new FrontController();
        return frontController;
    }

    public void start() {
        EventQueue.invokeLater(() -> new FrontView().setVisible(true));
    }

    public void dispatch(String address, ArrayList<Object> data) {
        try {
            Method method = this.controllersMap.get(address);
            method.invoke(null, data);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
