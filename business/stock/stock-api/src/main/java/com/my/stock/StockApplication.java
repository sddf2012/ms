package com.my.stock;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 11:28
 */
@Slf4j
@MapperScan("com.my.stock.repo")
//@EnableFeignClients(value = {"com.my.stock.feign"})
@EnableTransactionManagement
@ComponentScan({"com.my.stock", "com.my.include.common"})
@EnableDiscoveryClient
@SpringBootApplication
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
        log.info("stock 启动成功!!!");
    }
}
