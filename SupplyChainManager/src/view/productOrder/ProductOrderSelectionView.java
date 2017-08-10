package view.productOrder;

import controller.FrontController;
import model.productOrder.ProductOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderSelectionView extends JFrame {
    private JComboBox<Object> productOrder;

    public ProductOrderSelectionView(List<ProductOrder> productOrders) {
        initUI(productOrders);
    }

    private void initUI(List<ProductOrder> productOrders) {
        productOrder = new JComboBox<>(productOrders.toArray());
        add(productOrder);

        JButton nextButton = new JButton("ادامه");
        nextButton.addActionListener(e -> onNext());
        add(nextButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب گزارش سفارش محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onNext() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(productOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("productOrderSelectionNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("productOrderSelectionCancel", null);
        setVisible(false);
        dispose();
    }
}
