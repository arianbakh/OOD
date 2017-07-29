package view.customerOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomerOrderListView extends JFrame {
    public CustomerOrderListView(ArrayList<CustomerOrder> customerOrders) {
        initUI(customerOrders);
    }

    private void initUI(ArrayList<CustomerOrder> customerOrders) {
        String[] columnNames = {"تحویل‌دهنده", "زمان ثبت سفارش", "فرد درگیر", "زمان رسیدن"};
        Object[][] rows = new Object[customerOrders.size()][4];
        for(int i = 0; i < customerOrders.size(); i++) {
            rows[i][0] = customerOrders.get(i).getDeliverer();
            rows[i][1] = customerOrders.get(i).getOrderTime();
            if(customerOrders.get(i).getReport() != null){
	            rows[i][2] = customerOrders.get(i).getReport().getResponsiblePerson();
	            rows[i][3] = customerOrders.get(i).getReport().getReadyTime();
            } else {
            	rows[i][2] = "";
	            rows[i][3] = "";
            }
        }
        JTable customerOrdersTable = new JTable(rows, columnNames);
        customerOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for(int i = 0; i < customerOrdersTable.getColumnCount(); i++)
        	customerOrdersTable.getColumnModel().getColumn(i).setPreferredWidth(200);
        add(customerOrdersTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش سفارشات مشتری مرتبط");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("customerOrdersListReturn", null);
        setVisible(false);
        dispose();
    }
}
