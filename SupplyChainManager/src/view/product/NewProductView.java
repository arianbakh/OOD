package view.product;

import controller.FrontController;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewProductView extends JFrame {
    JList componentList;
    private JTextArea name;

    public NewProductView(List<Component> components) {
        initUI(components);
    }

    private void initUI(List<Component> components) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        componentList = new JList(components.toArray());
        componentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(componentList), gbc);

        name = new JTextArea(3, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(name, gbc);
        JLabel nameLabel = new JLabel("نام:");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(nameLabel, gbc);

        JButton submitOrderButton = new JButton("ثبت محصول");
        submitOrderButton.addActionListener(e -> onSubmit());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(submitOrderButton, gbc);

        JButton returnButton = new JButton("انصراف");
        returnButton.addActionListener(e -> onCancel());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(returnButton, gbc);

        add(panel);

        setLayout(new FlowLayout());
        setTitle("ثبت محصول جدید");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentList.getSelectedValues());
        data.add(name.getText());
        FrontController.getFrontController().dispatch("newProductSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("newProductCancel", null);
        setVisible(false);
        dispose();
    }
}
