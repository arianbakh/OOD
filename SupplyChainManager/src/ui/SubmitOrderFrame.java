package ui;

import db.CustomerOrder;
import db.DataBase;
import db.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class SubmitOrderFrame extends JFrame {
    SubmitOrderFrame() {
        initUI();
    }

    private void initUI() {
        JList productList = new JList(DataBase.getDB().getProducts().toArray());
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(productList));

        JButton submitOrderButton = new JButton("ثبت سفارش");
        submitOrderButton.addActionListener((ActionEvent e) -> {
            DataBase.getDB().addCustomerOrder(new CustomerOrder((Product)productList.getSelectedValue()));
            setVisible(false);
            dispose();
        });
        add(submitOrderButton);

        setLayout(new FlowLayout());
        setTitle("ثبت سفارش");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }
}
