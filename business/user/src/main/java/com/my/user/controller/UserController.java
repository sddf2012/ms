package com.my.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.my.include.feign.goods.GoodsFeign;
import com.my.user.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

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

    @GetMapping(value = "/login")
    public String login() {
        String a = goodsFeign.get();
        System.out.println(a);
        return "登录成功";
    }

    @GetMapping(value = "getUserAsync")
    public String getUserAsync() {
        return CompletableFuture.supplyAsync(() -> get()).thenApplyAsync(s -> JSONObject.toJSONString(s)).join();
    }

    @GetMapping(value = "getUser")
    public String getUser() {
        User user = get();
        return JSONObject.toJSONString(user);
    }

    User get() {
        User user = new User();
        user.setId("1");
        user.setCode("qq");
        user.setName("阿斯");
        return user;
    }

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable String id) {
        return "hello " + id;
    }
}
