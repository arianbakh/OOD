package view;

import javax.swing.*;

import controller.FrontController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
	private JButton submitCustomerOrderButton;
	private JButton submitProductReportButton;
	private JButton viewComponentsListButton;
    public MainFrame(){
        initUI();
    }

    private void initUI() {
        submitCustomerOrderButton = new JButton("ثبت سفارش جدید");
        submitCustomerOrderButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed (ActionEvent event) {
                onProductOrder(); 
            }
        });
        add(submitCustomerOrderButton);

        submitProductReportButton = new JButton("ثبت گزارش سفارش محصول");
        submitProductReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onSubmitProductionReport();
			}
		});
        add(submitProductReportButton);

        viewComponentsListButton = new JButton("مشاهده لبست مولفه‌های موجود");
        viewComponentsListButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onViewComponentsList();
			}
		});
        add(viewComponentsListButton);

        setLayout(new FlowLayout());
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void onProductOrder(){
    	FrontController.getFrontController().callController("newProductOrder", null);
    }
    
    private void onSubmitProductionReport() {
    	FrontController.getFrontController().callController("newProductOrderReportDialogue", null);
    }
    
    private void onViewComponentsList() {
    	FrontController.getFrontController().callController("listComponents", null);
    }
}
