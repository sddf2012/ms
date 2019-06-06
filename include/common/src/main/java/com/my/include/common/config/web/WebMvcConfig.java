package com.my.include.common.config.web;

import com.my.include.common.config.web.interceptor.CrosInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/3 20:16
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private CrosInterceptor crosInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(crosInterceptor).addPathPatterns("/**");
    }
}
