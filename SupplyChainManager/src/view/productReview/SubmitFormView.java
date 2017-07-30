package view.productReview;

import controller.FrontController;
import model.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubmitFormView extends JFrame {
    private JComboBox<Object> product;
    JSpinner qualitySpinner;
    JSpinner deliverySpinner;


    public SubmitFormView(ArrayList<Product> products) {
        initUI(products);
    }

    private void initUI(ArrayList<Product> products) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        product = new JComboBox<>(products.toArray());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(product, gbc);

        SpinnerModel qualityModel = new SpinnerNumberModel(0, 0, 5, 1);     
        qualitySpinner = new JSpinner(qualityModel);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(qualitySpinner, gbc);
        JLabel qualityLabel = new JLabel("کیفیت:");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(qualityLabel, gbc);
        
        SpinnerModel deliveryModel = new SpinnerNumberModel(0, 0, 5, 1);     
        deliverySpinner = new JSpinner(deliveryModel);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(deliverySpinner, gbc);
        JLabel deliveryLabel = new JLabel("تحویل‌دهی:");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(deliveryLabel, gbc);
        
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(submitButton, gbc);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(cancelButton, gbc);

        add(panel);

        setLayout(new FlowLayout());
        setTitle("ثبت بازخورد فرمی برای محصول");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        data.add(qualitySpinner.getModel().getValue());
        data.add(deliverySpinner.getModel().getValue());
        FrontController.getFrontController().dispatch("newFormReview", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("cancelFormReview", null);
        setVisible(false);
        dispose();
    }
}
