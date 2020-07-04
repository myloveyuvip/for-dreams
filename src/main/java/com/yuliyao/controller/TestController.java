package com.yuliyao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
@RestController
public class TestController {


    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
