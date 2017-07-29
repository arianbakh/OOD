package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;
import model.customerOrder.CustomerOrder;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentOrderSelectionView extends JFrame {
    private JComboBox<Object> componentOrder;

    public ComponentOrderSelectionView(ArrayList<ComponentOrder> componentOrders) {
        initUI(componentOrders);
    }

    private void initUI(ArrayList<ComponentOrder> componentOrders) {
        componentOrder = new JComboBox<>(componentOrders.toArray());
        add(componentOrder);

        JButton nextButton = new JButton("ادامه");
        nextButton.addActionListener(e -> onNext());
        add(nextButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب گزارش سفارش مولفه");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onNext() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("componentOrderSelectionNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("componentOrderSelectionCancel", null);
        setVisible(false);
        dispose();
    }
}
