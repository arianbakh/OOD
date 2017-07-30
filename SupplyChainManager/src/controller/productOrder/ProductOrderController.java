package controller.productOrder;

import java.util.ArrayList;
import java.util.HashMap;

import model.componentOrder.ComponentOrder;
import model.product.Component;
import model.product.Product;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;
import model.repository.ComponentOrderRepository;
import model.repository.CustomerOrderRepository;
import model.repository.ProductOrderRepository;
import model.repository.SupplierRepository;
import view.componentOrder.SelectComponentOrderForEditView;
import view.customerOrder.CustomerOrderListView;
import view.productOrder.ProductOrderListView;
import view.productOrder.SelectProductOrderForEditView;
import view.productOrder.SelectSupplierForEditView;

public class ProductOrderController {
    public static void startFilterProductOrders(ArrayList<Object> data) {
    	Product product = (Product)data.get(0);
    	new ProductOrderListView(ProductOrderRepository.getInstance().getByProduct(product)).setVisible(true);;
    }

    public static void selectProductsCancel(ArrayList<Object> data) {
    }

    public static void selectProductsNext(ArrayList<Object> data) {
    }

    public static void productOrderListReturn(ArrayList<Object> data) {
    }
    
    public static void startSelectSupplier(ArrayList<Object> data) {
    	new SelectProductOrderForEditView(ProductOrderRepository.getInstance().getAll()).setVisible(true);
    }

    public static void productOrderSelectionForEditCancel(ArrayList<Object> data) {
    }

    public static void productOrderSelectionForEditNext(ArrayList<Object> data) {
    	ProductOrder productOrder = (ProductOrder) data.get(0);
    	HashMap<Component, ArrayList<Supplier>> suppliers = new HashMap<>();
    	for (Component c: productOrder.getProduct().getComponents())
    		suppliers.put(c, SupplierRepository.filterByComponent(c));
    		
    	new SelectSupplierForEditView(suppliers, productOrder).setVisible(true);
    }

    public static void supplierSelectionForEditCancel(ArrayList<Object> data) {
    }

    public static void supplierSelectionForEditSubmit(ArrayList<Object> data) {
    	ProductOrder productOrder = (ProductOrder) data.get(0);
    	ArrayList<Supplier> suppliers = new ArrayList<>();
    	for(int i = 0; i < productOrder.getProduct().getComponents().size(); i++)
    		suppliers.add((Supplier)data.get(i+1));
    	productOrder.setSuppliers(suppliers);
    }
}
