package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentOrderSelectionView extends JFrame {
    private JComboBox<Object> componentOrder;

    public ComponentOrderSelectionView(List<ComponentOrder> componentOrders) {
        initUI(componentOrders);
    }

    private void initUI(List<ComponentOrder> componentOrders) {
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
