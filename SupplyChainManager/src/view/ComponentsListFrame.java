package view;

import javax.swing.*;

import database.DataBase;
import model.product.Component;

import java.awt.*;
import java.util.ArrayList;

public class ComponentsListFrame extends JFrame {
	private ArrayList<Component> components;
    public ComponentsListFrame(ArrayList<Component> components) {
    	this.components = components;
        initUI();
    }

    private void initUI() {
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
