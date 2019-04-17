package com.my;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
@Slf4j
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);

        log.info("config start!!!!");
    }
}
