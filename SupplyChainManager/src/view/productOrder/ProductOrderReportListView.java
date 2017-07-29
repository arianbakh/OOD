package view.productOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.productOrder.ProductOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductOrderReportListView extends JFrame {
    public ProductOrderReportListView(ProductOrder productOrder) {
        initUI(productOrder);
    }

    private void initUI(ProductOrder productOrder) {

        JLabel name = new JLabel(productOrder.getReport().getResponsiblePerson().toString());
        add(name);
        JLabel nameLabel = new JLabel("نام فرد:");
        add(nameLabel);
        
        JLabel time = new JLabel(productOrder.getReport().getReadyTime().toString());
        add(time);
        JLabel timeLabel = new JLabel("زمان:");
        add(timeLabel);
        
        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش گزارش سفارش محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("productOrderListReturn", null);
        setVisible(false);
        dispose();
    }
}
