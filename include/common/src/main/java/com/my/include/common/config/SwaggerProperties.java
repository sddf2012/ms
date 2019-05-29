package com.my.include.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/28 14:10
 */
@ConfigurationProperties(prefix = "swagger.api")
@Data
public class SwaggerProperties {
    private String title;

    private String description;

    private String version;
}
