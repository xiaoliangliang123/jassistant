package com.client.common.listener;

import com.client.common.presenter.ILoginPresenter;
import com.client.common.util.StringUtil;
import com.client.common.util.ViewUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginBtnListener implements ActionListener {


    private ILoginPresenter loginPresenter;

    public LoginBtnListener(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    public void actionPerformed(ActionEvent e) {

        String username = loginPresenter.getUsername();
        String password = loginPresenter.getPassword();
        String url = loginPresenter.getLoginUrl();

        if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
            ViewUtil.alert("用户名或密码不可以为空");
            return;
        }
        if(StringUtil.isEmpty(url)||StringUtil.hasChinese(url)){
            ViewUtil.alert("登录url地址不可以为空");
            return;
        }

        try {
            loginPresenter.login(url,username,password);
        }catch (Exception ex){
            ViewUtil.alert(ex.getMessage());
        }

     }
}
