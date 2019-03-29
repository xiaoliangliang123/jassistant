package com.client.common.config;


import com.client.Main;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanUtils {

    private static BeanUtils beanUtils =null;
    private  ApplicationContext ctx = null;

    public static BeanUtils getInstance() {

        if(beanUtils ==null){
            beanUtils = new BeanUtils();
        }
        return beanUtils;
    }


    public void init() {

        String path = Main.class.getClassLoader().getResource("bean-config.xml").getFile();
        ctx = new FileSystemXmlApplicationContext(path);
        beanUtils.setContext(ctx);
    }

    private void setContext(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public Object getBean(String beanId) throws BeansException{
        return ctx.getBean(beanId);
    }
}
