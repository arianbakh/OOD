package view.customerOrder;

import controller.FrontController;
import model.customerOrder.Deliverer;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeliverersListView extends JFrame {
    public DeliverersListView(ArrayList<Deliverer> deliverers) {
        initUI(deliverers);
    }

    private void initUI(ArrayList<Deliverer> deliverers) {
        String[] columnNames = {"نام", "ويژگی‌ها"};
        Object[][] rows = new Object[deliverers.size()][2];
        for(int i = 0; i < deliverers.size(); i++) {
            rows[i][0] = deliverers.get(i).getName();
            rows[i][1] = deliverers.get(i).getProperties();
        }
        JTable deliverersTable = new JTable(rows, columnNames);
        deliverersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for(int i = 0; i < deliverersTable.getColumnCount(); i++)
        	deliverersTable.getColumnModel().getColumn(i).setPreferredWidth(300);
        add(deliverersTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش مولفه‌های موجود");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("deliverersListReturn", null);
        setVisible(false);
        dispose();
    }
}
