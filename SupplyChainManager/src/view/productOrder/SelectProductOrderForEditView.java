package view.productOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.customerOrder.Deliverer;
import model.product.Component;
import model.product.Product;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class SelectProductOrderForEditView extends JFrame {
	private JComboBox<Object> productOrder;

    public SelectProductOrderForEditView(ArrayList<ProductOrder> productOrders) {
        initUI(productOrders);
    }

    private void initUI(ArrayList<ProductOrder> productOrders) {
        JButton submitButton = new JButton("ادامه");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);
        
        productOrder = new JComboBox<>(productOrders.toArray());
        add(productOrder);
        
        setLayout(new FlowLayout());
        setTitle("انتخاب مسیر تامین");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(productOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("productOrderSelectionForEditNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("productOrderSelectionForEditCancel", null);
        setVisible(false);
        dispose();
    }
}
