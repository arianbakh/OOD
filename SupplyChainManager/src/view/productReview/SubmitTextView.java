package view.productReview;

import controller.FrontController;
import model.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubmitTextView extends JFrame {
    private JComboBox<Object> product;
    private JTextArea text;

    public SubmitTextView(ArrayList<Product> products) {
        initUI(products);
    }

    private void initUI(ArrayList<Product> products) {
        product = new JComboBox<>(products.toArray());
        add(product);

        text = new JTextArea(10, 30);
        add(text);

        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("ثبت بازخورد متنی برای محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        data.add(text.getText());
        FrontController.getFrontController().dispatch("newTextReview", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("cancelTextReview", null);
        setVisible(false);
        dispose();
    }
}
