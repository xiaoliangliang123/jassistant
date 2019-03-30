package com.client.common.service.impl;


import com.client.common.model.JsonResult;
import com.client.common.service.CommonService;
import com.client.common.util.HttpUtil;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.util.JSONPObject;

public class CommonServiceImpl implements CommonService {


    public JsonResult login(String url, String username, String password) throws Exception {

        String loginResponse =  HttpUtil.httpClientLogin(username,password,url);

        JsonResult result = convertToJsonResult(loginResponse);
        return result;
    }

    @Override
    public JsonResult convertToJsonResult(String response) {
        JSONObject jsonObject = JSONObject.fromObject(response);
        Boolean isSuccess = jsonObject.getBoolean("success");
        String message = jsonObject.getString("message");
        return new JsonResult(isSuccess,message);
    }
}
