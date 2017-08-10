package view.productOrder;

import controller.FrontController;
import model.product.Component;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectSupplierForEditView extends JFrame {
    private ArrayList<JComboBox<Object>> supplier = new ArrayList<>();
    private ProductOrder productOrder;

    public SelectSupplierForEditView(Map<Component, List<Supplier>> suppliers, ProductOrder productOrder) {
        this.productOrder = productOrder;
        initUI(suppliers);
    }

    private void initUI(Map<Component, List<Supplier>> suppliers) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        for (Component c : suppliers.keySet()) {
            JLabel componentLabel = new JLabel(c.getName());
            add(componentLabel);

            JComboBox<Object> sups = new JComboBox<>(suppliers.get(c).toArray());
            supplier.add(sups);
            add(sups);
        }

        setLayout(new FlowLayout());
        setTitle("انتخاب تامین‌کننده");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(productOrder);
        for (JComboBox<Object> jcb : supplier)
            data.add(jcb.getSelectedItem());
        FrontController.getFrontController().dispatch("selectSupplierForEditSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("selectSupplierForEditCancel", null);
        setVisible(false);
        dispose();
    }
}
