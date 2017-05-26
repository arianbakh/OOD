package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    public MainFrame(){
        initUI();
    }

    private void initUI() {
        JButton submitOrderButton = new JButton("ثبت سفارش جدید");
        submitOrderButton.addActionListener((ActionEvent e) -> {
            new SubmitOrderFrame().setVisible(true);
        });
        add(submitOrderButton);

        JButton submitProductReportButton = new JButton("ثبت گزارش محصول");
        submitProductReportButton.addActionListener((ActionEvent e) -> {
            new SubmitProductReportFrame().setVisible(true);
        });
        add(submitProductReportButton);

        JButton viewComponentsListButton = new JButton("مشاهده لبست مولفه‌های موجود");
        viewComponentsListButton.addActionListener((ActionEvent e) -> {
            new ComponentsListFrame().setVisible(true);
        });
        add(viewComponentsListButton);

        setLayout(new FlowLayout());
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
