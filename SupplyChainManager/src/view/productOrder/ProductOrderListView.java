package view.productOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductOrderListView extends JFrame {
    public ProductOrderListView(ArrayList<ProductOrder> productOrders) {
        initUI(productOrders);
    }

    private void initUI(ArrayList<ProductOrder> productOrders) {
        String[] columnNames = {"مجموع قیمت", "زمان ثبت سفارش", "فرد درگیر", "زمان رسیدن"};
        Object[][] rows = new Object[productOrders.size()][4];
        for(int i = 0; i < productOrders.size(); i++) {
        	int sum = 0;
        	for (Supplier s: productOrders.get(i).getSuppliers())
        		sum += s.getPrice();
            rows[i][0] = sum;
            rows[i][1] = productOrders.get(i).getOrderTime();
            if(productOrders.get(i).getReport() != null){
	            rows[i][2] = productOrders.get(i).getReport().getResponsiblePerson();
	            rows[i][3] = productOrders.get(i).getReport().getReadyTime();
            } else {
            	rows[i][2] = "";
	            rows[i][3] = "";
            }
        }
        JTable productOrdersTable = new JTable(rows, columnNames);
        productOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for(int i = 0; i < productOrdersTable.getColumnCount(); i++)
        	productOrdersTable.getColumnModel().getColumn(i).setPreferredWidth(200);
        add(productOrdersTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش سفارشات محصول مرتبط");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("productOrdersListReturn", null);
        setVisible(false);
        dispose();
    }
}
