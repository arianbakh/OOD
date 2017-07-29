package view.componentOrder;

import controller.FrontController;
import model.componentOrder.ComponentOrder;
import model.customerOrder.CustomerOrder;
import model.order.Person;
import model.product.Component;
import model.product.Product;
import model.productOrder.ProductOrder;
import model.productOrder.Supplier;

import javax.swing.*;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class NewComponentOrderReportView extends JFrame {
	private JComboBox<Object> componentOrder;
	private JComboBox<Object> person;

    public NewComponentOrderReportView(ArrayList<ComponentOrder> componentOrders, ArrayList<Person> persons) {
        initUI(componentOrders, persons);
    }

    private void initUI(ArrayList<ComponentOrder> componentOrders, ArrayList<Person> persons) {
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
        setTitle("ثبت گزارش سفارش مشتری جدید");
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
