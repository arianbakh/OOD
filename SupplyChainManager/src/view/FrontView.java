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

        JButton selectDeliverer = new JButton("انتخاب مسیر تحویل");
        selectDeliverer.addActionListener(e -> onSelectDeliverer());
        add(selectDeliverer);
        
        JButton selectSupplier = new JButton("انتخاب مسیر تامین");
        selectSupplier.addActionListener(e -> onSelectSupplier());
        add(selectSupplier);

        JButton showExistingDeliverers = new JButton("دریافت مسیر‌های تحویل");
        showExistingDeliverers.addActionListener(e -> onShowExistingDeliverers());
        add(showExistingDeliverers);
        
        JButton showExistingSuppliers = new JButton("دریافت مسیر‌های تامین");
        showExistingSuppliers.addActionListener(e -> onShowExistingSuppliers());
        add(showExistingSuppliers);

        JButton newCustomerOrderReport = new JButton("ثبت گزارش سفارش مشتری جدید");
        newCustomerOrderReport.addActionListener(e -> onNewCustomerOrderReport());
        add(newCustomerOrderReport);
        
        JButton newProductOrderReport = new JButton("ثبت گزارش سفارش محصول جدید");
        newProductOrderReport.addActionListener(e -> onNewProductOrderReport());
        add(newProductOrderReport);
        
        JButton newComponentOrderReport = new JButton("ثبت گزارش سفارش مولفه جدید");
        newComponentOrderReport.addActionListener(e -> onNewComponentOrderReport());
        add(newComponentOrderReport);
        
        JButton getCustomerOrderReport = new JButton("دریافت گزارش سفارش مشتری");
        getCustomerOrderReport.addActionListener(e -> onGetCustomerOrderReport());
        add(getCustomerOrderReport);
        
        JButton getProductOrderReport = new JButton("دریافت گزارش سفارش محصول");
        getProductOrderReport.addActionListener(e -> onGetProductOrderReport());
        add(getProductOrderReport);


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
    
    private void onSelectDeliverer() {
        FrontController.getFrontController().dispatch("startSelectDeliverer", null);
    }
    
    private void onSelectSupplier() {
        FrontController.getFrontController().dispatch("startSelectSupplier", null);
    }
    
    private void onShowExistingDeliverers() {
        FrontController.getFrontController().dispatch("startGetDeliverers", null);
    }
    
    private void onShowExistingSuppliers() {
        FrontController.getFrontController().dispatch("startGetSuppliers", null);
    }
    
    private void onNewCustomerOrderReport() {
        FrontController.getFrontController().dispatch("startNewCustomerOrderReport", null);
    }
    
    private void onNewProductOrderReport() {
        FrontController.getFrontController().dispatch("startNewProductOrderReport", null);
    }
    
    private void onNewComponentOrderReport() {
        FrontController.getFrontController().dispatch("startNewComponentOrderReport", null);
    }
    
    private void onGetCustomerOrderReport() {
        FrontController.getFrontController().dispatch("startGetCustomerOrderReport", null);
    }
    
    private void onGetProductOrderReport() {
        FrontController.getFrontController().dispatch("startGetProductOrderReport", null);
    }
}
