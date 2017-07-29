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
        product = new JComboBox<>(products.toArray());
        add(product);

        SpinnerModel qualityModel = new SpinnerNumberModel(0, 0, 5, 1);     
        qualitySpinner = new JSpinner(qualityModel);
        add(qualitySpinner);
        JLabel qualityLabel = new JLabel("کیفیت:");
        add(qualityLabel);
        
        SpinnerModel deliveryModel = new SpinnerNumberModel(0, 0, 5, 1);     
        deliverySpinner = new JSpinner(deliveryModel);
        add(deliverySpinner);
        JLabel deliveryLabel = new JLabel("تحویل‌دهی:");
        add(deliveryLabel);
        
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("ثبت بازخورد فرمی برای محصول");
        setSize(800, 450);
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
