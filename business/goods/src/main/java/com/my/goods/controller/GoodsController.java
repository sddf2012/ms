package com.my.goods.controller;

import com.my.include.feign.user.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/29 10:05
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserFeign feign;

    @RequestMapping("/get")
    public String get() throws InterruptedException {
        int i = new Random().nextInt(4);
        System.out.println("i:" + i);
        Thread.sleep(i * 1000);
        return "book";
    }

    @RequestMapping("/test")
    public String test() {
        return feign.getById("1");
    }
}
