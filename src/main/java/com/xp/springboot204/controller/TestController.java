package com.xp.springboot204.controller;

import com.xp.springboot204.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author Climb.Xu
 * @date 2020/4/27 20:56
 */
@Controller
public class TestController {
    @Resource
    private UserNotFoundException userNotFoundException;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("username") String name) {
        if (!"xp".equals(name)) {
            throw userNotFoundException;
        }
        return "hello world";
    }
}
