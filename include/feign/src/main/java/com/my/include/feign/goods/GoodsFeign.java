package com.my.include.feign.goods;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/29 10:30
 */
@FeignClient(name = "goods",path = "/goods")
public interface GoodsFeign {
    @RequestMapping("/get")
    String get();
}
