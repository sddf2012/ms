package com.my.user.controller;

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
    @GetMapping("/login")
    public String login() throws InterruptedException {
        int i= new Random().nextInt(4);
        Thread.sleep(i*1000);
        return "登录成功";
    }
}
