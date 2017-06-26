package view;

import javax.swing.*;

import controller.FrontController;
import database.DataBase;
import model.order.Person;
import model.product.Product;
import model.productOrder.ProductOrderReport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class SubmitProductReportFrame extends JFrame {
    public SubmitProductReportFrame() {
        initUI();
    }

    private void initUI() {
        JLabel productLabel = new JLabel("محصول");
        productLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(productLabel);

        JLabel personsLabel = new JLabel("افراد درگیر");
        personsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(personsLabel);

        JLabel emptyLabel = new JLabel("");
        add(emptyLabel);

        JList productList = new JList(DataBase.getDB().getProducts().toArray());
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(productList));

        JList personsList = new JList(DataBase.getDB().getPersons().toArray());
        personsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(personsList));

        JButton submitReportButton = new JButton("ثبت گزارش");
        submitReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Person> persons = new ArrayList(Arrays.asList(personsList.getSelectedValues()));
				onSubmit((Product)productList.getSelectedValue(), persons);
				setVisible(false);
				dispose();
			}
		});
        JPanel submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout());
        submitButtonPanel.add(submitReportButton);
        add(submitButtonPanel);

        setLayout(new GridLayout(2, 5));
        setTitle("ثبت گزارش محصول");
        setSize(800, 450);
        setLocationRelativeTo(null);
    }
    
    private void onSubmit(Product product, ArrayList<Person> persons) {
    	ArrayList<Object> data = new ArrayList<>();
    	data.add(product);
    	data.add(persons);
    	FrontController.getFrontController().callController("newProductOrderReport", data);
    }
}
