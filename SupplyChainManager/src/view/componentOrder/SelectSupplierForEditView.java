package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class SelectSupplierForEditView extends JFrame {
	private JComboBox<Object> supplier;
	private ComponentOrder componentOrder;

    public SelectSupplierForEditView(ArrayList<Supplier> suppliers, ComponentOrder componentOrder) {
    	this.componentOrder = componentOrder;
        initUI(suppliers);
    }

    private void initUI(ArrayList<Supplier> suppliers) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);
        
        supplier = new JComboBox<>(suppliers.toArray());
        add(supplier);
        
        setLayout(new FlowLayout());
        setTitle("انتخاب تامین‌کننده");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentOrder);
        data.add(supplier.getSelectedItem());
        FrontController.getFrontController().dispatch("selectSupplierForEditSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("selectSupplierForEditCancel", null);
        setVisible(false);
        dispose();
    }
}
