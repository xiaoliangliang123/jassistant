package com.client.common.view;


import com.client.common.listener.LoginBtnListener;
import com.client.common.listener.UrlFieldHintListener;
import com.client.common.presenter.ILoginPresenter;
import com.client.common.view.iview.ILoginView;
import com.client.common.presenter.impl.LoginPresenterImpl;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame implements ILoginView {

    JTextField urlField = new JTextField(40);
    JTextField usernameField = new JTextField(15);
    JTextField passwordField = new JTextField(15);

    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");


    JPanel nullPanel = new JPanel();
    JPanel urlPanel = new JPanel();
    JPanel usernamePanel = new JPanel();
    JPanel passwordPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    JLabel usernameLabel = new JLabel(StringText.LOGIN_WINDOW_USERNAME_LABEL,JLabel.CENTER);
    JLabel passwordLabel = new JLabel(StringText.LOGIN_WINDOW_PASSWORD_LABEL,JLabel.CENTER);

    public LoginWindow(){


        this.setLayout(new GridLayout(5,3,30,10)); //默认为1行，n列；2行3列，水平间距10，垂直间距5
        this.add(nullPanel);
        this.add(urlPanel);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(buttonsPanel);
        this.setTitle(StringText.SYSTEM_TITLE);


        usernameLabel.setFont(new Font("字体", Font.PLAIN, 20));
        passwordLabel.setFont(new Font("字体", Font.PLAIN, 20));



        usernamePanel.setLayout(new FlowLayout());
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);


        urlField.setPreferredSize(new Dimension (300,30));
        urlField.addFocusListener(new UrlFieldHintListener("请填写登录后台url路径",urlField));
        urlField.setText("http://localhost:8090/common/login");
        usernameField.setPreferredSize(new Dimension (200,30));

        passwordField.setPreferredSize(new Dimension (200,30));
        urlPanel.add(urlField);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(resetButton);

        this.setResizable(false);
        this.setSize(550,300);
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                usernameField.requestFocus();
            }
        });

        ILoginPresenter loginPresenter = new LoginPresenterImpl(this);
        loginButton.addActionListener(new LoginBtnListener(loginPresenter));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }



    public void visible() {
        this.setVisible(true);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getLoginUrl() {
        return urlField.getText();
    }

    @Override
    public void jump2Window() {
        this.dispose();
        MainWindow mainWindow = new MainWindow();
        mainWindow.visible();
    }
}
