package com.my.config;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liu peng bo
 * date: 2020/5/22 11:52
 */
@Configuration
public class MyConfiguration {
    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean(ConfigurableEnvironment env) {
        EurekaClientConfigBean client = new MyEurekaClientConfigBean();
        /*if ("bootstrap".equals(this.env.getProperty("spring.config.name"))) {
            client.setRegisterWithEureka(false);
        }*/
        return client;
    }
}
