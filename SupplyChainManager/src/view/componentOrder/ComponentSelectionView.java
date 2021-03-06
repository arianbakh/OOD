package view.componentOrder;

import controller.FrontController;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComponentSelectionView extends JFrame {
    private JComboBox<Object> component;

    public ComponentSelectionView(List<Component> components) {
        initUI(components);
    }

    private void initUI(List<Component> components) {
        component = new JComboBox<>(components.toArray());
        add(component);

        JButton nextButton = new JButton("ادامه");
        nextButton.addActionListener(e -> onNext());
        add(nextButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب مولفه");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onNext() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(component.getSelectedItem());
        FrontController.getFrontController().dispatch("componentSelectionNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("componentSelectionCancel", null);
        setVisible(false);
        dispose();
    }
}
