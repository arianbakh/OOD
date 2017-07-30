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
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        componentList = new JList(components.toArray());
        componentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(componentList), gbc);

        JButton submitOrderButton = new JButton("ثبت سفارش");
        submitOrderButton.addActionListener(e -> onSubmit());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(submitOrderButton, gbc);

        JButton returnButton = new JButton("انصراف");
        returnButton.addActionListener(e -> onCancel());
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(returnButton, gbc);

        add(panel);

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
