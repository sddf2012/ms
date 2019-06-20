package com.my.stock;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 11:28
 */
@Slf4j
@SpringCloudApplication
@MapperScan("com.my.stock.repo")
@EnableFeignClients("com.my.stock.feign")
@EnableTransactionManagement
@ComponentScan({"com.my.stock", "com.my.include.common"})
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
        log.info("stock 启动成功!!!");
    }
}
