package ui;

import db.DataBase;
import db.Person;
import db.Product;
import db.ProductReport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.ArrayList;

class SubmitProductReportFrame extends JFrame {
    SubmitProductReportFrame() {
        initUI();
    }

    private void initUI() {
        JLabel productLabel = new JLabel("محصول");
        productLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(productLabel);

        JLabel durationLabel = new JLabel("مدت زمان");
        durationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(durationLabel);

        JLabel personsLabel = new JLabel("افراد درگیر");
        personsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(personsLabel);

        JLabel suggestionsLabel = new JLabel("پیشنهادات");
        suggestionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(suggestionsLabel);

        JLabel emptyLabel = new JLabel("");
        add(emptyLabel);

        JList productList = new JList(DataBase.getDB().getProducts().toArray());
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(productList));

        JTextField durationField = new JTextField();
        add(durationField);

        JList personsList = new JList(DataBase.getDB().getPersons().toArray());
        personsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(personsList));

        JTextArea suggestionTextArea = new JTextArea();
        add(suggestionTextArea);

        JButton submitReportButton = new JButton("ثبت گزارش");
        submitReportButton.addActionListener((ActionEvent e) -> {
            ArrayList<Person> persons = new ArrayList<>(personsList.getSelectedValuesList());
            DataBase.getDB().addProductReport(new ProductReport(
                    (Product)productList.getSelectedValue(),
                    Duration.ofDays(Integer.valueOf(durationField.getText())),
                    persons,
                    suggestionTextArea.getText()
            ));
            setVisible(false);
            dispose();
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
}
