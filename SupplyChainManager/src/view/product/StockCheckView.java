package view.product;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import controller.FrontController;
import model.product.Component;
import model.product.Product;

public class StockCheckView extends JFrame{
	public StockCheckView(ArrayList<Product> products) {
        initUI(products);
    }

    private void initUI(ArrayList<Product> products) {
        String[] columnNames = {"محصول", "موجودی"};
        Object[][] rows = new Object[products.size()][2];
        for(int i = 0; i < products.size(); i++) {
        	rows[i][0] = products.get(i).getCurrentStock();
            rows[i][1] = products.get(i);
        }
        JTable componentsTable = new JTable(rows, columnNames);
        add(componentsTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش وضعیت موجودی محصولات");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("componentsListReturn", null);
        setVisible(false);
        dispose();
    }
}

