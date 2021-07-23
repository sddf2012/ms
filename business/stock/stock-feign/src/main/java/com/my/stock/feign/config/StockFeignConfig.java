package com.my.stock.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liu peng bo
 * date: 2021/7/22 16:25
 */
@Slf4j
public class StockFeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        log.info("stock interceptor test!");
    }
}
