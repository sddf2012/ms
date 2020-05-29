package com.my.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * date: 2020/5/25 17:17
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.ac = applicationContext;
    }

    public static  <T> T getBean(Class<T> tClass) {
        return ac.getBean(tClass);
    }
}
