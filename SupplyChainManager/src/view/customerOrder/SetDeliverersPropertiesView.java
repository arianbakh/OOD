package view.customerOrder;

import controller.FrontController;
import model.product.Component;
import model.product.Product;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class SetDeliverersPropertiesView extends JFrame {
    private JTextArea name;
    private JTextArea properties;

    public SetDeliverersPropertiesView() {
        initUI();
    }

    private void initUI() {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);
        
        properties = new JTextArea(10, 30);
        add(properties);
        JLabel priceLabel = new JLabel("ویژگی‌ها:");
        add(priceLabel);
        
        name = new JTextArea(3, 10);
        add(name);
        JLabel nameLabel = new JLabel("نام:");
        add(nameLabel);

        setLayout(new FlowLayout());
        setTitle("ثبت ویژگی‌های مسیر تامین جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(name.getText());
        data.add(properties.getText());
        FrontController.getFrontController().dispatch("setDelivererPropertiesSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("setDelivererPropertiesCancel", null);
        setVisible(false);
        dispose();
    }
}
