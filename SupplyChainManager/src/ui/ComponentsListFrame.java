package ui;

import db.Component;
import db.DataBase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ComponentsListFrame extends JFrame {
    ComponentsListFrame() {
        initUI();
    }

    private void initUI() {
        ArrayList<Component> components = DataBase.getDB().getComponents();
        for(Component component: components) {
            JLabel componentLabel = new JLabel(component.getName());
            componentLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(componentLabel);
        }

        setLayout(new GridLayout(components.size(), 1));
        setTitle("لیست مولفه‌های موجود");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }
}
