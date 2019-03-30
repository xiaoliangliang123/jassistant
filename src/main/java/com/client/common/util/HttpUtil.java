package com.client.common.util;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpUtil {

    public static String httpClientLogin(String userName, String password,
                                         String loginUrl) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();
        HttpPost httpPost = new HttpPost(loginUrl.trim());
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("username", userName));
        list.add(new BasicNameValuePair("password", password));
        httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        Header[] responseHeader = response.getHeaders("Set-Cookie");
        for (Header header : responseHeader) {
            if (header != null) {
                System.out.println(header.getName() + ":" + header.getValue());
            }
        }

        if (response.getStatusLine().getStatusCode() == 302) {
            String locationUrl = response.getLastHeader("Location").getValue();
            entity = httpRequest(locationUrl);//跳转到重定向的url
        }
        String responseBody = "";
        if (entity != null) {
            responseBody = EntityUtils.toString(entity, "utf-8");
        }
        System.out.println(responseBody);
        return responseBody;

    }

    public static HttpEntity httpRequest(String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();
        HttpPost httpPost = new HttpPost(url.trim());
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        return entity;
    }
}
