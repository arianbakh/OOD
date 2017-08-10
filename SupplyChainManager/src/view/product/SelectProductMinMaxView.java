package view.product;

import controller.FrontController;
import model.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectProductMinMaxView extends JFrame {
    private JComboBox<Object> product;
    JSpinner maxSpinner;
    JSpinner minSpinner;

    public SelectProductMinMaxView(List<Product> products) {
        initUI(products);
    }

    private void initUI(List<Product> products) {

        SpinnerModel maxModel = new SpinnerNumberModel(0, 0, 100, 1);
        maxSpinner = new JSpinner(maxModel);
        add(maxSpinner);
        JLabel maxLabel = new JLabel("حداکثر:");
        add(maxLabel);

        SpinnerModel minModel = new SpinnerNumberModel(0, 0, 100, 1);
        minSpinner = new JSpinner(minModel);
        add(minSpinner);
        JLabel minLabel = new JLabel("حداقل:");
        add(minLabel);

        product = new JComboBox<>(products.toArray());
        add(product);

        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب حداقل و حداکثری موجودی محصولات");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }


    private void onCancel() {
        FrontController.getFrontController().dispatch("selectProductMinMaxCancel", null);
        setVisible(false);
        dispose();
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        data.add(minSpinner.getModel().getValue());
        data.add(maxSpinner.getModel().getValue());
        FrontController.getFrontController().dispatch("selectProductMinMaxSubmit", data);
        setVisible(false);
        dispose();
    }
}

