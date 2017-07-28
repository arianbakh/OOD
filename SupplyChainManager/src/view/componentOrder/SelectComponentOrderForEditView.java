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

public class SelectComponentOrderForEditView extends JFrame {
	private JComboBox<Object> componentOrder;

    public SelectComponentOrderForEditView(ArrayList<ComponentOrder> componentOrders) {
        initUI(componentOrders);
    }

    private void initUI(ArrayList<ComponentOrder> componentOrders) {
        JButton submitButton = new JButton("ادامه");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);
        
        componentOrder = new JComboBox<>(componentOrders.toArray());
        add(componentOrder);
        
        setLayout(new FlowLayout());
        setTitle("انتخاب مسیر تامین");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("componentOrderSelectionForEditNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("componentOrderSelectionForEditCancel", null);
        setVisible(false);
        dispose();
    }
}
