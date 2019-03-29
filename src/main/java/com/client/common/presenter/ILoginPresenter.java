package com.client.common.presenter;

import com.client.common.model.JsonResult;
import com.client.common.view.iview.ILoginView;

public interface ILoginPresenter extends ILoginView {

    JsonResult login(String url,String username,String password) throws Exception;



}
