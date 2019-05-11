package com.my.include.feign.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/29 10:30
 */
@FeignClient(name = "user", path = "/user")
public interface UserFeign {
    @RequestMapping("/getById/{id}")
    String getById(@PathVariable String id);
}
