package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectComponentOrderForEditView extends JFrame {
    private JComboBox<Object> componentOrder;

    public SelectComponentOrderForEditView(List<ComponentOrder> componentOrders) {
        initUI(componentOrders);
    }

    private void initUI(List<ComponentOrder> componentOrders) {
        JButton submitButton = new JButton("ادامه");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        componentOrder = new JComboBox<>(componentOrders.toArray());
        add(componentOrder);

        setLayout(new FlowLayout());
        setTitle("انتخاب مسیر تامین");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentOrder.getSelectedItem());
        FrontController.getFrontController().dispatch("componentOrderSelectionForEditNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("componentOrderSelectionForEditCancel", null);
        setVisible(false);
        dispose();
    }
}
