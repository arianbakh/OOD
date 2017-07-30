package view.product;

import controller.FrontController;
import model.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowFamiliarsView extends JFrame {
    private JComboBox<Object> product;


    public ShowFamiliarsView(ArrayList<Product> products) {
        initUI(products);
    }

    private void initUI(ArrayList<Product> products) {
        product = new JComboBox<>(products.toArray());
        add(product);

        JButton customerOrdersButton = new JButton("نمایش سفارشات مشتری");
        customerOrdersButton.addActionListener(e -> onShowCustomerOrders());
        add(customerOrdersButton);
        
        JButton productOrdersButton = new JButton("نمایش سفارشات محصول");
        productOrdersButton.addActionListener(e -> onShowProductOrders());
        add(productOrdersButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("نمایش محصولات مشابه");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onShowCustomerOrders() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        FrontController.getFrontController().dispatch("customerOrdersList", data);
        setVisible(false);
        dispose();
    }
    
    private void onShowProductOrders() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        FrontController.getFrontController().dispatch("productOrdersList", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("productListReturn", null);
        setVisible(false);
        dispose();
    }
}
