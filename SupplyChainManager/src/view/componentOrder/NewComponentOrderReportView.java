package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;
import model.order.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewComponentOrderReportView extends JFrame {
    private JComboBox<Object> componentOrder;
    private JComboBox<Object> person;

    public NewComponentOrderReportView(List<ComponentOrder> componentOrders, List<Person> persons) {
        initUI(componentOrders, persons);
    }

    private void initUI(List<ComponentOrder> componentOrders, List<Person> persons) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);


        person = new JComboBox<>(persons.toArray());
        add(person);

        componentOrder = new JComboBox<>(componentOrders.toArray());
        add(componentOrder);

        setLayout(new FlowLayout());
        setTitle("ثبت گزارش سفارش مولفه جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(componentOrder.getSelectedItem());
        data.add(person.getSelectedItem());
        FrontController.getFrontController().dispatch("newComponentOrderReportSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("newComponentOrderReportCancel", null);
        setVisible(false);
        dispose();
    }
}
