package com.client.common.service;

import com.client.common.model.JsonResult;

public interface CommonService  {

     JsonResult login(String url, String username, String password) throws Exception;


     JsonResult convertToJsonResult(String response);



}
