package com.daoyuan.study.data.desensitization.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext ctxt;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctxt = applicationContext;
    }

    public static <T> T getBean(String beanName,Class<T> clazz){
        return ctxt.getBean(beanName,clazz);
    }

    public static <T> T getBean(Class<T> clazz){
        return ctxt.getBean(clazz);
    }
}
