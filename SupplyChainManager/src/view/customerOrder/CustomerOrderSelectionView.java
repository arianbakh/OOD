package view.customerOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomerOrderSelectionView extends JFrame {
    private JComboBox<Object> customerOrder;

    public CustomerOrderSelectionView(ArrayList<CustomerOrder> customerOrders) {
        initUI(customerOrders);
    }

    private void initUI(ArrayList<CustomerOrder> customerOrders) {
        customerOrder = new JComboBox<>(customerOrders.toArray());
        add(customerOrder);

        JButton nextButton = new JButton("ادامه");
        nextButton.addActionListener(e -> onNext());
        add(nextButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب گزارش سفارش مشتری");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onNext() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(customerOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("customerOrderSelectionNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("customerOrderSelectionCancel", null);
        setVisible(false);
        dispose();
    }
}
