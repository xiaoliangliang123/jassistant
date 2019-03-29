package com.client.common.presenter.impl;

import com.client.common.config.BeanUtils;
import com.client.common.model.JsonResult;
import com.client.common.presenter.ILoginPresenter;
import com.client.common.service.CommonService;
import com.client.common.view.iview.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter {


    private ILoginView loginView;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
    }


    public JsonResult login(String url, String username, String password) throws Exception {

        CommonService commonService = (CommonService) BeanUtils.getInstance().getBean("commonService");
        return (JsonResult) commonService.login(url, username, password);
    }

    public String getUsername() {
        return loginView.getUsername();
    }

    public String getPassword() {
        return loginView.getPassword();
    }

    public String getLoginUrl() {
        return loginView.getLoginUrl();
    }


}
