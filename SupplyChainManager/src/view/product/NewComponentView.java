package view.product;

import controller.FrontController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewComponentView extends JFrame {
    private JTextArea name;

    public NewComponentView() {
        initUI();
    }

    private void initUI() {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        name = new JTextArea(3, 10);
        add(name);
        JLabel nameLabel = new JLabel("نام:");
        add(nameLabel);

        setLayout(new FlowLayout());
        setTitle("ثبت مولفه‌ی جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(name.getText());
        FrontController.getFrontController().dispatch("newComponentSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("newComponentCancel", null);
        setVisible(false);
        dispose();
    }
}
