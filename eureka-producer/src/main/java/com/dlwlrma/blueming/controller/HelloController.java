package com.dlwlrma.blueming.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author:hex1n
 * @Date:2020/1/15 16:23
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${server.port}")
    private int instance;

    @GetMapping("/")
    public String hello(@RequestParam String name) {

        return "[" + instance + "]" + "hello, " + name + " " + new Date();
    }
}
