package com.my.include.common.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 跨域问题
 *
 * @author liu peng bo
 * date: 2019/5/7 11:13
 */
@ControllerAdvice
public class CrosConfig implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletServerHttpResponse ssResp = (ServletServerHttpResponse) response;
        ssResp.getServletResponse().addHeader("Access-Control-Allow-Origin", "*");
        return body;
    }
}
