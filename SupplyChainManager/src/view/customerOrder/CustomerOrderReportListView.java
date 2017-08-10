package view.customerOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;

import javax.swing.*;
import java.awt.*;

public class CustomerOrderReportListView extends JFrame {
    public CustomerOrderReportListView(CustomerOrder customerOrder) {
        initUI(customerOrder);
    }

    private void initUI(CustomerOrder customerOrder) {

        if (customerOrder.getReport() != null) {
            JLabel name = new JLabel(customerOrder.getReport().getResponsiblePerson().toString());
            add(name);
        }
        JLabel nameLabel = new JLabel("نام فرد:");
        add(nameLabel);
        if (customerOrder.getReport() != null) {
            JLabel time = new JLabel(customerOrder.getReport().getReadyTime().toString());
            add(time);
        }
        JLabel timeLabel = new JLabel("زمان:");
        add(timeLabel);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش گزارش سفارش مشتری");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("customerOrderListReturn", null);
        setVisible(false);
        dispose();
    }
}
