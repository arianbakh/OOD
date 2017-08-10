package view.productReview;

import controller.FrontController;
import model.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SubmitTextView extends JFrame {
    private JComboBox<Object> product;
    private JTextArea text;

    public SubmitTextView(List<Product> products) {
        initUI(products);
    }

    private void initUI(List<Product> products) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        product = new JComboBox<>(products.toArray());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(product, gbc);

        text = new JTextArea(10, 30);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(text, gbc);

        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(submitButton, gbc);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(cancelButton, gbc);

        add(panel);

        setLayout(new FlowLayout());
        setTitle("ثبت بازخورد متنی برای محصول");
        setSize(800, 600);
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
