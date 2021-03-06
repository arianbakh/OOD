package view.product;

import controller.FrontController;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectComponentsView extends JFrame {
    JList componentList;

    public SelectComponentsView(List<Component> components) {
        initUI(components);
    }

    private void initUI(List<Component> components) {
        componentList = new JList(components.toArray());
        componentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(componentList));

        JButton submitOrderButton = new JButton("ادامه");
        submitOrderButton.addActionListener(e -> onNext());
        add(submitOrderButton);

        JButton returnButton = new JButton("انصراف");
        returnButton.addActionListener(e -> onCancel());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("انتخاب مولفه‌های محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onNext() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentList.getSelectedValues());
        FrontController.getFrontController().dispatch("selectComponentsNext", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("selectComponentsCancel", null);
        setVisible(false);
        dispose();
    }
}
