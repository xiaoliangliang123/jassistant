package com.client.common.service.impl;


import com.client.common.service.CommonService;
import com.client.common.util.HttpUtil;

public class CommonServiceImpl implements CommonService {


    public Object login(String url,String username, String password) throws Exception {

        return HttpUtil.HttpClientLogin(username,password,url);
    }
}
