package com.client;

import com.client.common.config.BeanUtils;
import com.client.common.view.LoginWindow;



public class Main {


    public static void main(String[] args) {


        BeanUtils.getInstance().init();
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.visible();

    }
}
