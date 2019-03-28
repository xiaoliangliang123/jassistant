package com.client.view;

import com.client.values.StringText;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame{

    JTextField usernameField = new JTextField(15);
    JTextField passwordField = new JTextField(15);

    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");


    JPanel nullPanel = new JPanel();
    JPanel usernamePanel = new JPanel();
    JPanel passwordPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    JLabel usernameLabel = new JLabel(StringText.LOGIN_WINDOW_USERNAME_LABEL,JLabel.CENTER);
    JLabel passwordLabel = new JLabel(StringText.LOGIN_WINDOW_PASSWORD_LABEL,JLabel.CENTER);
    JLabel nullLabel = new JLabel();

    public LoginWindow(){


        this.setLayout(new GridLayout(4,3,30,10)); //默认为1行，n列；2行3列，水平间距10，垂直间距5
        this.add(nullPanel);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(buttonsPanel);
        this.setTitle(StringText.SYSTEM_TITLE);


        usernameLabel.setFont(new Font("字体", Font.PLAIN, 20));
        passwordLabel.setFont(new Font("字体", Font.PLAIN, 20));


        this.setResizable(false);
        usernamePanel.setLayout(new FlowLayout());
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        usernameField.setPreferredSize(new Dimension (200,30));
        passwordField.setPreferredSize(new Dimension (200,30));

        buttonsPanel.add(loginButton);
        buttonsPanel.add(resetButton);

        this.setSize(500,300);
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
        this.setVisible(true);

    }
}
