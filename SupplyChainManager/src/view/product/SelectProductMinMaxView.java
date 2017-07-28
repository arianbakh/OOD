package view.product;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.FrontController;
import model.product.Component;
import model.product.Product;

public class SelectProductMinMaxView extends JFrame{
    private JComboBox<Object> product;
    JSpinner maxSpinner;
    JSpinner minSpinner;

	public SelectProductMinMaxView(ArrayList<Product> products) {
        initUI(products);
    }

    private void initUI(ArrayList<Product> products) {

        SpinnerModel maxModel = new SpinnerNumberModel(0, 0, 100, 1);     
        maxSpinner = new JSpinner(maxModel);
        add(maxSpinner);
        JLabel maxLabel = new JLabel("حداکثر:");
        add(maxLabel);

        SpinnerModel minModel = new SpinnerNumberModel(0, 0, 100, 1);     
        minSpinner = new JSpinner(minModel);
        add(minSpinner);
        JLabel minLabel = new JLabel("حداقل:");
        add(minLabel);
        
        product = new JComboBox<>(products.toArray());
        add(product);
        
        JButton submitButton = new JButton("ثبت");
        submitButton.addActionListener(e -> onSubmit());
        add(submitButton);

        JButton cancelButton = new JButton("انصراف");
        cancelButton.addActionListener(e -> onCancel());
        add(cancelButton);

        setLayout(new FlowLayout());
        setTitle("ثبت بازخورد متنی برای محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }


    private void onCancel() {
        FrontController.getFrontController().dispatch("selectProductMinMaxCancel", null);
        setVisible(false);
        dispose();
    }
    
    private void onSubmit() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(product.getSelectedItem());
        data.add(minSpinner.getModel().getValue());
        data.add(maxSpinner.getModel().getValue());
        FrontController.getFrontController().dispatch("selectProductMinMaxSubmit", data);
        setVisible(false);
        dispose();
    }
}

