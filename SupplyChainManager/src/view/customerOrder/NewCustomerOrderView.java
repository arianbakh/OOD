package view.customerOrder;

import controller.FrontController;
import model.customerOrder.Deliverer;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewCustomerOrderView extends JFrame {
	JList componentList;
    public NewCustomerOrderView(ArrayList<Component> components) {
        initUI(components);
    }

    private void initUI(ArrayList<Component> components) {
    	componentList = new JList(components.toArray());
    	componentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    	add(new JScrollPane(componentList));
    	
    	JButton submitOrderButton = new JButton("ثبت سفارش");
    	submitOrderButton.addActionListener(e -> onSubmit());
    	add(submitOrderButton);
    	
        JButton returnButton = new JButton("انصراف");
        returnButton.addActionListener(e -> onCancel());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("ثبت سفارش");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
    	ArrayList<Object> data = new ArrayList<>();
    	data.add(componentList.getSelectedValues());
    	FrontController.getFrontController().dispatch("newCustomerOrderSubmit", data);
        setVisible(false);
        dispose();
    }
    private void onCancel() {
        FrontController.getFrontController().dispatch("newCustomerOrderCancel", null);
        setVisible(false);
        dispose();
    }
}
