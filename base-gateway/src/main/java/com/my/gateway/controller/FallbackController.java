package com.my.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/28 16:24
 */
@RestController
@RequestMapping("/gateway")
public class FallbackController {
    @GetMapping("/fallback")
    public String fallback() {
        return "fallback";
    }
}
