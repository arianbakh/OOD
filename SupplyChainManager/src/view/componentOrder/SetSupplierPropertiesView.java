package view.componentOrder;

import controller.FrontController;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SetSupplierPropertiesView extends JFrame {
    private JComboBox<Object> component;
    private JTextArea name;
    JSpinner price;

    public SetSupplierPropertiesView(List<Component> components) {
        initUI(components);
    }

    private void initUI(List<Component> components) {
        component = new JComboBox<>(components.toArray());
        add(component);

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

        SpinnerModel priceModel = new SpinnerNumberModel(0, 0, 100000, 1);
        price = new JSpinner(priceModel);
        add(price);
        JLabel priceLabel = new JLabel("قیمت:");
        add(priceLabel);


        setLayout(new FlowLayout());
        setTitle("ثبت ویژگی‌های مسیر تامین جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(component.getSelectedItem());
        data.add(name.getText());
        data.add(price.getModel().getValue());
        FrontController.getFrontController().dispatch("setSupplierPropertiesSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("setSupplierPropertiesCancel", null);
        setVisible(false);
        dispose();
    }
}
