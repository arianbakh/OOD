package view;

import controller.FrontController;

import javax.swing.*;
import java.awt.*;

public class FrontView extends JFrame {
    public FrontView() {
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;

    	JButton newCustomerOrderButton = new JButton("ثبت سفارش مشتری");
        newCustomerOrderButton.addActionListener(e -> onNewCustomerOrder());
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(newCustomerOrderButton, gbc);

        JButton newCustomerOrderReport = new JButton("ثبت گزارش سفارش مشتری");
        newCustomerOrderReport.addActionListener(e -> onNewCustomerOrderReport());
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(newCustomerOrderReport, gbc);

        JButton getCustomerOrderReport = new JButton("دریافت گزارش سفارش مشتری");
        getCustomerOrderReport.addActionListener(e -> onGetCustomerOrderReport());
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(getCustomerOrderReport, gbc);

        JButton newComponentButton = new JButton("افزودن مولفه‌ی جدید");
        newComponentButton.addActionListener(e -> onNewComponent());
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(newComponentButton, gbc);
        
        JButton showExistingComponentsButton = new JButton("نمایش مولفه‌های موجود");
        showExistingComponentsButton.addActionListener(e -> onShowExistingComponents());
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(showExistingComponentsButton, gbc);

        JButton newComponentOrderButton = new JButton("ثبت سفارش مولفه");
        newComponentOrderButton.addActionListener(e -> onNewComponentOrder());
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newComponentOrderButton, gbc);

        JButton newComponentOrderReport = new JButton("ثبت گزارش سفارش مولفه");
        newComponentOrderReport.addActionListener(e -> onNewComponentOrderReport());
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(newComponentOrderReport, gbc);

        JButton getComponentOrderReport = new JButton("دریافت گزارش سفارش مولفه");
        getComponentOrderReport.addActionListener(e -> onGetComponentOrderReport());
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(getComponentOrderReport, gbc);

        JButton newProductOrderReport = new JButton("ثبت گزارش سفارش محصول");
        newProductOrderReport.addActionListener(e -> onNewProductOrderReport());
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(newProductOrderReport, gbc);
        
        JButton getProductOrderReport = new JButton("دریافت گزارش سفارش محصول");
        getProductOrderReport.addActionListener(e -> onGetProductOrderReport());
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(getProductOrderReport, gbc);

        JButton newProductButton = new JButton("ثبت محصول جدید");
        newProductButton.addActionListener(e -> onNewProduct());
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(newProductButton, gbc);
        
        JButton viewProductStock = new JButton("نمایش موجودی محصولات");
        viewProductStock.addActionListener(e -> onViewStock());
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(viewProductStock, gbc);

        JButton setMaxMinStock = new JButton("تعیین حداقل و حداکثر موجودی محصولات");
        setMaxMinStock.addActionListener(e -> onSetProductStock());
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(setMaxMinStock, gbc);

        JButton newFormProductReviewButton = new JButton("ثبت بازخورد فرمی برای محصول");
        newFormProductReviewButton.addActionListener(e -> onNewFormProductReview());
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(newFormProductReviewButton, gbc);

        JButton newTextProductReviewButton = new JButton("ثبت بازخورد متنی برای محصول");
        newTextProductReviewButton.addActionListener(e -> onNewTextProductReview());
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(newTextProductReviewButton, gbc);

        JButton setSupplierProperties = new JButton("تعیین ویژگی‌های مسیر تامین");
        setSupplierProperties.addActionListener(e -> onSetSupplierProperties());
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(setSupplierProperties, gbc);
        
        JButton showExistingSuppliers = new JButton("دریافت مسیر‌های تامین");
        showExistingSuppliers.addActionListener(e -> onShowExistingSuppliers());
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(showExistingSuppliers, gbc);
        
        JButton selectSupplier = new JButton("انتخاب مسیر تامین");
        selectSupplier.addActionListener(e -> onSelectSupplier());
        gbc.gridx = 2;
        gbc.gridy = 6;
        panel.add(selectSupplier, gbc);

        JButton setDeliverersProperties = new JButton("تعیین ویژگی‌های مسیر تحویل");
        setDeliverersProperties.addActionListener(e -> onSetDeliverersProperties());
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(setDeliverersProperties, gbc);

        JButton showExistingDeliverers = new JButton("دریافت مسیر‌های تحویل");
        showExistingDeliverers.addActionListener(e -> onShowExistingDeliverers());
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(showExistingDeliverers, gbc);

        JButton selectDeliverer = new JButton("انتخاب مسیر تحویل");
        selectDeliverer.addActionListener(e -> onSelectDeliverer());
        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(selectDeliverer, gbc);
        
        JButton prediction = new JButton("پیش‌بینی");
        prediction.addActionListener(e -> onFilterProducts());
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(prediction, gbc);

        JButton newPersonButton = new JButton("افزودن شخص جدید");
        newPersonButton.addActionListener(e -> onNewPerson());
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(newPersonButton, gbc);
        
        add(panel);

        setLayout(new FlowLayout());
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(1024, 768);
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

    private void onNewComponent() {
        FrontController.getFrontController().dispatch("startNewComponent", null);
    }
    
    private void onShowExistingComponents() {
        FrontController.getFrontController().dispatch("showExistingComponents", null);
    }

    private void onNewComponentOrder() {
        FrontController.getFrontController().dispatch("startNewComponentOrder", null);
    }

    private void onNewProduct() {
        FrontController.getFrontController().dispatch("startNewProduct", null);
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
    
    private void onNewPerson() {
        FrontController.getFrontController().dispatch("startNewPerson", null);
    }
}
