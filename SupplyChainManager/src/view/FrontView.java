package view;

import controller.FrontController;

import javax.swing.*;
import java.awt.*;

public class FrontView extends JFrame {
    public FrontView() {
        initUI();
    }

    private void initUI() {
    	
        JButton newTextProductReviewButton = new JButton("ثبت بازخورد متنی برای محصول");
        newTextProductReviewButton.addActionListener(e -> onNewTextProductReview());
        add(newTextProductReviewButton);

        JButton showExistingComponentsButton = new JButton("نمایش مولفه‌های موجود");
        showExistingComponentsButton.addActionListener(e -> onShowExistingComponents());
        add(showExistingComponentsButton);

        JButton newComponentOrderButton = new JButton("سفارش مولفه جدید");
        newComponentOrderButton.addActionListener(e -> onNewComponentOrder());
        add(newComponentOrderButton);

        JButton viewProductStock = new JButton("نمایش موجودی محصولات");
        viewProductStock.addActionListener(e -> onViewStock());
        add(viewProductStock);
        
        JButton setMaxMinStock = new JButton("تعیین حداقل و حداکثر موجودی محصولات");
        setMaxMinStock.addActionListener(e -> onSetProductStock());
        add(setMaxMinStock);
        
        JButton setSupplierProperties = new JButton("تعیین ویژگی‌های مسیر تامین جدید");
        setSupplierProperties.addActionListener(e -> onSetSupplierProperties());
        add(setSupplierProperties);
        
        JButton setDeliverersProperties = new JButton("تعیین ویژگی‌های مسیر تحویل جدید");
        setDeliverersProperties.addActionListener(e -> onSetDeliverersProperties());
        add(setDeliverersProperties);

        setLayout(new FlowLayout());
//        setLayout(new GridLayout(0, 3));
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void onNewTextProductReview() {
        FrontController.getFrontController().dispatch("startTextProductReview", null);
    }

    private void onShowExistingComponents() {
        FrontController.getFrontController().dispatch("showExistingComponents", null);
    }

    private void onNewComponentOrder() {
        FrontController.getFrontController().dispatch("startNewComponentOrder", null);
    }

    private void onViewStock() {
        FrontController.getFrontController().dispatch("viewStock", null);
    }
    
    private void onSetProductStock() {
        FrontController.getFrontController().dispatch("startSetProductStock", null);
    }
    
    private void onSetSupplierProperties() {
        FrontController.getFrontController().dispatch("startSetSupplierProperties", null);
    }
    
    private void onSetDeliverersProperties() {
        FrontController.getFrontController().dispatch("startSetDelivererProperties", null);
    }
}
