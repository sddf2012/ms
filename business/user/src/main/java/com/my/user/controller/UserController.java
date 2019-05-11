package com.my.user.controller;

import com.my.include.feign.goods.GoodsFeign;
import com.my.user.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "getAll")
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setCode("qq");
        user.setName("阿斯");

        User user2 = new User();
        user2.setId("2");
        user2.setCode("ww");
        user2.setName("微软");
        list.add(user);
        list.add(user2);
        return list;
    }

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable String id) {
        return "hello " + id;
    }
}
