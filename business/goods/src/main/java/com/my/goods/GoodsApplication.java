package com.my.goods;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/29 10:06
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.my.include.feign"})
@Slf4j
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
        log.info("goods启动成功!!!");
    }
}
