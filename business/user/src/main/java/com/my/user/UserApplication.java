package com.my.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liu peng bo
 * @date 2019/4/21
 */
@Slf4j
@SpringCloudApplication
@ComponentScan("com.my")
//@EnableFeignClients(basePackages = {"com.my.include.feign"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.info("UserApplication 启动成功!!!");
    }
}
