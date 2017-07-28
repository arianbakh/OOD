package view.productOrder;

import controller.FrontController;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.productOrder.Supplier;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SupplierListView extends JFrame {
    public SupplierListView(ArrayList<Supplier> suppliers) {
        initUI(suppliers);
    }

    private void initUI(ArrayList<Supplier> suppliers) {
        String[] columnNames = {"نام", "قیمت", "مولفه"};
        Object[][] rows = new Object[suppliers.size()][3];
        for(int i = 0; i < suppliers.size(); i++) {
            rows[i][0] = suppliers.get(i).getName();
            rows[i][1] = suppliers.get(i).getPrice();
            rows[i][2] = suppliers.get(i).getComponent();
        }
        JTable deliverersTable = new JTable(rows, columnNames);
        deliverersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for(int i = 0; i < deliverersTable.getColumnCount(); i++)
        	deliverersTable.getColumnModel().getColumn(i).setPreferredWidth(200);
        add(deliverersTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش تامین‌کنندگان موجود");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("suppliersListReturn", null);
        setVisible(false);
        dispose();
    }
}
