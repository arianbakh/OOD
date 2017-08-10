package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;

import javax.swing.*;
import java.awt.*;

public class ComponentOrderReportListView extends JFrame {
    public ComponentOrderReportListView(ComponentOrder componentOrder) {
        initUI(componentOrder);
    }

    private void initUI(ComponentOrder componentOrder) {

        if (componentOrder.getReport() != null) {
            JLabel name = new JLabel(componentOrder.getReport().getResponsiblePerson().toString());
            add(name);
        }
        JLabel nameLabel = new JLabel("نام فرد:");
        add(nameLabel);

        if (componentOrder.getReport() != null) {
            JLabel time = new JLabel(componentOrder.getReport().getReadyTime().toString());
            add(time);
        }
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
