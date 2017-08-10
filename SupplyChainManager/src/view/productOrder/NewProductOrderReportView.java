package view.productOrder;

import controller.FrontController;
import model.order.Person;
import model.productOrder.ProductOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewProductOrderReportView extends JFrame {
    private JComboBox<Object> productOrder;
    private JComboBox<Object> person;

    public NewProductOrderReportView(List<ProductOrder> productOrders, List<Person> persons) {
        initUI(productOrders, persons);
    }

    private void initUI(List<ProductOrder> productOrders, List<Person> persons) {
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);


        person = new JComboBox<>(persons.toArray());
        add(person);

        productOrder = new JComboBox<>(productOrders.toArray());
        add(productOrder);

        setLayout(new FlowLayout());
        setTitle("ثبت گزارش سفارش محصول جدید");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(productOrder.getSelectedItem());
        data.add(person.getSelectedItem());
        FrontController.getFrontController().dispatch("newProductOrderReportSubmit", data);
        setVisible(false);
        dispose();
    }

    private void onCancel() {
        FrontController.getFrontController().dispatch("newProductOrderReportCancel", null);
        setVisible(false);
        dispose();
    }
}
