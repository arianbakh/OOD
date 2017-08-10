package view.customerOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class SelectDeliverer extends JFrame {
	private JComboBox<Object> customerOrder;
	private JComboBox<Object> deliverer;

    public SelectDeliverer(ArrayList<CustomerOrder> customerOrders, ArrayList<Deliverer> deliverers) {
        initUI(customerOrders, deliverers);
    }

    private void initUI(ArrayList<CustomerOrder> customerOrders, ArrayList<Deliverer> deliverers) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);
        
        customerOrder = new JComboBox<>(customerOrders.toArray());
        add(customerOrder);
        
        deliverer = new JComboBox<>(deliverers.toArray());
        add(deliverer);
        
        setLayout(new FlowLayout());
        setTitle("انتخاب مسیر تحویل");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(customerOrder.getSelectedItem());
        data.add(deliverer.getSelectedItem());
        FrontController.getFrontController().dispatch("selectDelivererSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("selectDelivererCancel", null);
        setVisible(false);
        dispose();
    }
}
