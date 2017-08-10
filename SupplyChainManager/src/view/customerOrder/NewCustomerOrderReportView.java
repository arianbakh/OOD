package view.customerOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.order.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewCustomerOrderReportView extends JFrame {
    private JComboBox<Object> customerOrder;
    private JComboBox<Object> person;

    public NewCustomerOrderReportView(List<CustomerOrder> customerOrders, List<Person> persons) {
        initUI(customerOrders, persons);
    }

    private void initUI(List<CustomerOrder> customerOrders, List<Person> persons) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);


        person = new JComboBox<>(persons.toArray());
        add(person);

        customerOrder = new JComboBox<>(customerOrders.toArray());
        add(customerOrder);

        setLayout(new FlowLayout());
        setTitle("ثبت گزارش سفارش مشتری جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(customerOrder.getSelectedItem());
        data.add(person.getSelectedItem());
        FrontController.getFrontController().dispatch("newCustomerOrderReportSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("newCustomerOrderReportCancel", null);
        setVisible(false);
        dispose();
    }
}
