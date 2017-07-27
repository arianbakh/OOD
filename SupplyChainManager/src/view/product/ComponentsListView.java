package view.product;

import controller.FrontController;
import model.product.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentsListView extends JFrame {
    public ComponentsListView(ArrayList<Component> components) {
        initUI(components);
    }

    private void initUI(ArrayList<Component> components) {
        String[] columnNames = {"مولفه"};
        Object[][] rows = new Object[components.size()][1];
        for(int i = 0; i < components.size(); i++) {
            rows[i][0] = components.get(i);
        }
        JTable componentsTable = new JTable(rows, columnNames);
        add(componentsTable);

        JButton returnButton = new JButton("بازگشت");
        returnButton.addActionListener(e -> onReturn());
        add(returnButton);

        setLayout(new FlowLayout());
        setTitle("نمایش مولفه‌های موجود");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onReturn() {
        FrontController.getFrontController().dispatch("componentsListReturn", null);
        setVisible(false);
        dispose();
    }
}
