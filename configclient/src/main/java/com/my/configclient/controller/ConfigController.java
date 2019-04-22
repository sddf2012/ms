package com.my.configclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu peng bo
 * @date 2019/4/20
 */
@Slf4j
@RestController
public class ConfigController {
    @Autowired
    private Environment environment;

    @Value("${k1}")
    private String k1;

    @GetMapping("/value/{key}")
    public String getValueByKey(@PathVariable String key) {
        return environment.getProperty(key);
    }

    @GetMapping("/k1")
    public String getK1() {
        log.info("get value!");
        return k1;
    }
}
