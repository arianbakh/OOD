package view;

import javax.swing.*;

import controller.FrontController;
import database.DataBase;
import model.customerOrder.CustomerOrder;
import model.product.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SubmitCustomerOrderFrame extends JFrame {
	private ArrayList<model.product.Component> components;
	private JList componentsList;
    public SubmitCustomerOrderFrame(ArrayList<model.product.Component> components) {
    	this.components = components;
        initUI();
    }

    private void initUI() {
        componentsList = new JList(components.toArray());
        componentsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(componentsList));

        JButton submitOrderButton = new JButton("ثبت سفارش");
        submitOrderButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				onSubmit(componentsList.getSelectedValues());
			}
		});
        add(submitOrderButton);

        setLayout(new FlowLayout());
        setTitle("ثبت سفارش");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }
    
    private void onSubmit(Object[] components) {
    	FrontController.getFrontController().callController("newCustomerOrder", new ArrayList<>(Arrays.asList(components)));
    	setVisible(false);
    	dispose();
    }
}
