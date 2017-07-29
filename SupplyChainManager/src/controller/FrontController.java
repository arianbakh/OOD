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
            this.controllersMap.put("startNewComponentOrder",
                    controller.componentOrder.ComponentOrderController.class.getMethod("startNewComponentOrder", ArrayList.class));
            this.controllersMap.put("componentSelectionCancel",
                    controller.componentOrder.ComponentOrderController.class.getMethod("componentSelectionCancel", ArrayList.class));
            this.controllersMap.put("componentSelectionNext",
                    controller.componentOrder.ComponentOrderController.class.getMethod("componentSelectionNext", ArrayList.class));
            this.controllersMap.put("supplierSelectionForNewSubmit",
                    controller.componentOrder.ComponentOrderController.class.getMethod("supplierSelectionForNewSubmit", ArrayList.class));
            this.controllersMap.put("supplierSelectionForNewCancel",
                    controller.componentOrder.ComponentOrderController.class.getMethod("supplierSelectionForNewCancel", ArrayList.class));
            this.controllersMap.put("viewStock",
                    controller.product.ProductController.class.getMethod("startViewStock", ArrayList.class));
            this.controllersMap.put("startSetProductStock",
                    controller.product.ProductController.class.getMethod("startSetProductStock", ArrayList.class));
            this.controllersMap.put("selectProductMinMaxCancel",
                    controller.product.ProductController.class.getMethod("selectProductMinMaxCancel", ArrayList.class));
            this.controllersMap.put("selectProductMinMaxSubmit",
                    controller.product.ProductController.class.getMethod("selectProductMinMaxSubmit", ArrayList.class));
            this.controllersMap.put("startSetSupplierProperties",
                    controller.componentOrder.ComponentOrderController.class.getMethod("startSetSupplierProperties", ArrayList.class));
            this.controllersMap.put("setSupplierPropertiesSubmit",
                    controller.componentOrder.ComponentOrderController.class.getMethod("setSupplierPropertiesSubmit", ArrayList.class));
            this.controllersMap.put("setSupplierPropertiesCancel",
                    controller.componentOrder.ComponentOrderController.class.getMethod("setSupplierPropertiesCancel", ArrayList.class));
            this.controllersMap.put("startSetDelivererProperties",
                    controller.customerOrder.DelivererController.class.getMethod("startSetDelivererProperties", ArrayList.class));
            this.controllersMap.put("setDelivererPropertiesSubmit",
                    controller.customerOrder.DelivererController.class.getMethod("setDelivererPropertiesSubmit", ArrayList.class));
            this.controllersMap.put("setDelivererPropertiesCancel",
                    controller.customerOrder.DelivererController.class.getMethod("setDelivererPropertiesCancel", ArrayList.class));
            this.controllersMap.put("startSelectDeliverer",
                    controller.customerOrder.CustomerOrderController.class.getMethod("startSelectDeliverer", ArrayList.class));
            this.controllersMap.put("selectDelivererSubmit",
                    controller.customerOrder.CustomerOrderController.class.getMethod("selectDelivererSubmit", ArrayList.class));
            this.controllersMap.put("selectDelivererCancel",
                    controller.customerOrder.CustomerOrderController.class.getMethod("selectDelivererCancel", ArrayList.class));
            this.controllersMap.put("startSelectSupplier",
            		controller.componentOrder.ComponentOrderController.class.getMethod("startSelectSupplier", ArrayList.class));
            this.controllersMap.put("componentOrderSelectionForEditNext",
                    controller.componentOrder.ComponentOrderController.class.getMethod("componentOrderSelectionForEditNext", ArrayList.class));
            this.controllersMap.put("componentOrderSelectionForEditCancel",
                    controller.componentOrder.ComponentOrderController.class.getMethod("componentOrderSelectionForEditCancel", ArrayList.class));
            this.controllersMap.put("selectSupplierForEditSubmit",
                    controller.componentOrder.ComponentOrderController.class.getMethod("supplierSelectionForEditSubmit", ArrayList.class));
            this.controllersMap.put("selectSupplierForEditCancel",
                    controller.componentOrder.ComponentOrderController.class.getMethod("supplierSelectionForEditCancel", ArrayList.class));
            this.controllersMap.put("startGetDeliverers",
                    controller.customerOrder.DelivererController.class.getMethod("startGetDeliverers", ArrayList.class));
            this.controllersMap.put("deliverersListReturn",
                    controller.customerOrder.DelivererController.class.getMethod("deliverersListReturn", ArrayList.class));
            this.controllersMap.put("startGetSuppliers",
                    controller.productOrder.SupplierController.class.getMethod("startGetSuppliers", ArrayList.class));
            this.controllersMap.put("suppliersListReturn",
                    controller.productOrder.SupplierController.class.getMethod("suppliersListReturn", ArrayList.class));
            this.controllersMap.put("startNewCustomerOrderReport",
                    controller.customerOrder.CustomerOrderReportController.class.getMethod("startNewCustomerOrderReport", ArrayList.class));
            this.controllersMap.put("newCustomerOrderReportSubmit",
                    controller.customerOrder.CustomerOrderReportController.class.getMethod("newCustomerOrderReportSubmit", ArrayList.class));
            this.controllersMap.put("newCustomerOrderReportCancel",
                    controller.customerOrder.CustomerOrderReportController.class.getMethod("newCustomerOrderReportCancel", ArrayList.class));
            this.controllersMap.put("startNewProductOrderReport",
                    controller.productOrder.ProductOrderReportController.class.getMethod("startNewProductOrderReport", ArrayList.class));
            this.controllersMap.put("newProductOrderReportSubmit",
                    controller.productOrder.ProductOrderReportController.class.getMethod("newProductOrderReportSubmit", ArrayList.class));
            this.controllersMap.put("newProductOrderReportCancel",
                    controller.productOrder.ProductOrderReportController.class.getMethod("newProductOrderReportCancel", ArrayList.class));
            this.controllersMap.put("startNewComponentOrderReport",
                    controller.componentOrder.ComponentOrderReportController.class.getMethod("startNewComponentOrderReport", ArrayList.class));
            this.controllersMap.put("newComponentOrderReportSubmit",
                    controller.componentOrder.ComponentOrderReportController.class.getMethod("newComponentOrderReportSubmit", ArrayList.class));
            this.controllersMap.put("newComponentOrderReportCancel",
                    controller.componentOrder.ComponentOrderReportController.class.getMethod("newComponentOrderReportCancel", ArrayList.class));
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
