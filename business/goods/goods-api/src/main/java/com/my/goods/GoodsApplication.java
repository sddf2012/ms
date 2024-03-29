package com.my.goods;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/29 10:06
 */
@EnableFeignClients(basePackages = {"com.my.*.feign"})
@MapperScan("com.my.goods.repo")
@ComponentScan({"com.my.goods", "com.my.include.common", "com.my.*.feign.callback"})
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
        log.info("goods启动成功!!!");
    }
}
