package com.mingx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuqiangxin
 * @Classname: UserController
 * @Description: 用户控制类
 * @date 2020/5/15 16:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/getPassword")
    public String helloUser() {
        return "hello, You password is " + password;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello, I'm meed you very Happy!";
    }
}
