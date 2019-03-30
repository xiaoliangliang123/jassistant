package com.client.common.view;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    JTabbedPane jTabbedPane = new JTabbedPane(SwingConstants.LEFT);
    JPanel jPanel = new JPanel();
    JPanel jPanel2 = new JPanel();
    public MainWindow(){

        jTabbedPane.add(StringText.MAIN_WINDOW_JTABBEDPANED_GONG_NENG_JI_HE,jPanel);
        jTabbedPane.add(StringText.MAIN_WINDOW_JTABBEDPANED_SHOU_DONG_PEI_ZHI,jPanel2);

        this.setTitle(StringText.SYSTEM_TITLE);
        this.setSize(700,600);
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.add(jTabbedPane);
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void visible() {
        this.setVisible(true);
    }
}
