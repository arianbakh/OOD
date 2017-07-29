package view.productOrder;

import controller.FrontController;
import model.customerOrder.CustomerOrder;
import model.order.Person;
import model.product.Component;
import model.product.Product;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class NewProductOrderReportView extends JFrame {
	private JComboBox<Object> productOrder;
	private JComboBox<Object> person;

    public NewProductOrderReportView(ArrayList<ProductOrder> productOrders, ArrayList<Person> persons) {
        initUI(productOrders, persons);
    }

    private void initUI(ArrayList<ProductOrder> productOrders, ArrayList<Person> persons) {
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
        setTitle("ثبت گزارش سفارش مشتری جدید");
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
