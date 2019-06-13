package com.my.system;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 11:25
 */
@Slf4j
@EnableFeignClients(basePackages = {"com.my.system.feign"})
@MapperScan("com.my.system.repo")
@ComponentScan({"com.my.system","com.my.include.common"})
@SpringCloudApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
        log.info("system启动成功!!!");
    }
}
