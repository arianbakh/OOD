package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentOrderReportListView extends JFrame {
    public ComponentOrderReportListView(ComponentOrder componentOrder) {
        initUI(componentOrder);
    }

    private void initUI(ComponentOrder componentOrder) {

        JLabel name = new JLabel(componentOrder.getReport().getResponsiblePerson().toString());
        add(name);
        JLabel nameLabel = new JLabel("نام فرد:");
        add(nameLabel);
        
        JLabel time = new JLabel(componentOrder.getReport().getReadyTime().toString());
        add(time);
        JLabel timeLabel = new JLabel("زمان:");
        add(timeLabel);
        
        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش گزارش سفارش مولفه");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("componentOrderListReturn", null);
        setVisible(false);
        dispose();
    }
}
