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

        setLayout(new FlowLayout());
        setTitle("سامانه مدیریت زنجیره تأمین");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void onNewTextProductReview() {
        FrontController.getFrontController().dispatch("startTextProductReview", null);
    }
}
