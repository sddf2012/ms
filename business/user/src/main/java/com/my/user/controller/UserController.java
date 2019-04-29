package com.my.user.controller;

import com.my.feign.goods.GoodsFeign;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/28 9:19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GoodsFeign goodsFeign;

    @GetMapping("/login")
    public String login() throws InterruptedException {
        String a = goodsFeign.get();
        System.out.println(a);
        return "登录成功";
    }
}
