package view;

import controller.FrontController;

import javax.swing.*;
import java.awt.*;

public class FrontView extends JFrame {
    public FrontView() {
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(21, 1));

    	JButton newCustomerOrderButton = new JButton("ثبت سفارش");
        newCustomerOrderButton.addActionListener(e -> onNewCustomerOrder());
        panel.add(newCustomerOrderButton);

    	JButton newFormProductReviewButton = new JButton("ثبت بازخورد فرمی برای محصول");
        newFormProductReviewButton.addActionListener(e -> onNewFormProductReview());
        panel.add(newFormProductReviewButton);

        JButton newTextProductReviewButton = new JButton("ثبت بازخورد متنی برای محصول");
        newTextProductReviewButton.addActionListener(e -> onNewTextProductReview());
        panel.add(newTextProductReviewButton);

        JButton showExistingComponentsButton = new JButton("نمایش مولفه‌های موجود");
        showExistingComponentsButton.addActionListener(e -> onShowExistingComponents());
        panel.add(showExistingComponentsButton);

        JButton newComponentOrderButton = new JButton("سفارش مولفه جدید");
        newComponentOrderButton.addActionListener(e -> onNewComponentOrder());
        panel.add(newComponentOrderButton);

        JButton viewProductStock = new JButton("نمایش موجودی محصولات");
        viewProductStock.addActionListener(e -> onViewStock());
        panel.add(viewProductStock);
        
        JButton setMaxMinStock = new JButton("تعیین حداقل و حداکثر موجودی محصولات");
        setMaxMinStock.addActionListener(e -> onSetProductStock());
        panel.add(setMaxMinStock);
        
        JButton setSupplierProperties = new JButton("تعیین ویژگی‌های مسیر تامین جدید");
        setSupplierProperties.addActionListener(e -> onSetSupplierProperties());
        panel.add(setSupplierProperties);
        
        JButton setDeliverersProperties = new JButton("تعیین ویژگی‌های مسیر تحویل جدید");
        setDeliverersProperties.addActionListener(e -> onSetDeliverersProperties());
        panel.add(setDeliverersProperties);

        JButton selectDeliverer = new JButton("انتخاب مسیر تحویل");
        selectDeliverer.addActionListener(e -> onSelectDeliverer());
        panel.add(selectDeliverer);
        
        JButton selectSupplier = new JButton("انتخاب مسیر تامین");
        selectSupplier.addActionListener(e -> onSelectSupplier());
        panel.add(selectSupplier);

        JButton showExistingDeliverers = new JButton("دریافت مسیر‌های تحویل");
        showExistingDeliverers.addActionListener(e -> onShowExistingDeliverers());
        panel.add(showExistingDeliverers);
        
        JButton showExistingSuppliers = new JButton("دریافت مسیر‌های تامین");
        showExistingSuppliers.addActionListener(e -> onShowExistingSuppliers());
        panel.add(showExistingSuppliers);

        JButton newCustomerOrderReport = new JButton("ثبت گزارش سفارش مشتری جدید");
        newCustomerOrderReport.addActionListener(e -> onNewCustomerOrderReport());
        panel.add(newCustomerOrderReport);
        
        JButton newProductOrderReport = new JButton("ثبت گزارش سفارش محصول جدید");
        newProductOrderReport.addActionListener(e -> onNewProductOrderReport());
        panel.add(newProductOrderReport);
        
        JButton newComponentOrderReport = new JButton("ثبت گزارش سفارش مولفه جدید");
        newComponentOrderReport.addActionListener(e -> onNewComponentOrderReport());
        panel.add(newComponentOrderReport);
        
        JButton getCustomerOrderReport = new JButton("دریافت گزارش سفارش مشتری");
        getCustomerOrderReport.addActionListener(e -> onGetCustomerOrderReport());
        panel.add(getCustomerOrderReport);
        
        JButton getProductOrderReport = new JButton("دریافت گزارش سفارش محصول");
        getProductOrderReport.addActionListener(e -> onGetProductOrderReport());
        panel.add(getProductOrderReport);
        
        JButton getComponentOrderReport = new JButton("دریافت گزارش سفارش مولفه");
        getComponentOrderReport.addActionListener(e -> onGetComponentOrderReport());
        panel.add(getComponentOrderReport);
        
        JButton prediction = new JButton("پیش‌بینی");
        prediction.addActionListener(e -> onFilterProducts());
        panel.add(prediction);

        add(panel);

        setLayout(new FlowLayout());
//        setLayout(new GridLayout(0, 3));
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void onNewCustomerOrder() {
        FrontController.getFrontController().dispatch("newCustomerOrder", null);
    }
    
    private void onNewFormProductReview() {
        FrontController.getFrontController().dispatch("startFormProductReview", null);
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
    
    private void onGetComponentOrderReport() {
        FrontController.getFrontController().dispatch("startGetComponentOrderReport", null);
    }
    
    private void onFilterProducts() {
        FrontController.getFrontController().dispatch("startFilterProducts", null);
    }
}
