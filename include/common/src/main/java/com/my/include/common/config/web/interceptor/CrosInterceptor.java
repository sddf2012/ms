package com.my.include.common.config.web.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/3 20:12
 */
@Component
public class CrosInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader(HttpHeaders.ORIGIN) != null) {
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Headers:", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client");
            response.addHeader("Access-Control-Allow-Methods", "*");
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Expose-Headers", "*");
            response.addHeader("Access-Control-Max-Age", "18000L");
        }
        return true;
    }
}
