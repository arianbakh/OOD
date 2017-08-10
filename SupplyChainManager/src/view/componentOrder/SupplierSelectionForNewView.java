package view.componentOrder;

import controller.FrontController;
import model.productOrder.Supplier;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierSelectionForNewView extends JFrame {
    private JComboBox<Object> supplier;
    private JTextArea text;

    public SupplierSelectionForNewView(List<Supplier> suppliers) {
        initUI(suppliers);
    }

    private void initUI(List<Supplier> suppliers) {
        supplier = new JComboBox<>(suppliers.toArray());
        add(supplier);

        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب تامین‌کننده");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(supplier.getSelectedItem());
        FrontController.getFrontController().dispatch("supplierSelectionForNewSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("supplierSelectionForNewCancel", null);
        setVisible(false);
        dispose();
    }
}
