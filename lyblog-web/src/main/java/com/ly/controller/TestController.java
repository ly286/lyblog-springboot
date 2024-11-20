package com.ly.controller;

import com.ly.aspect.ApiOperationLog;
import com.ly.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: dly
 * @Date: 2024-11-19-23:39
 * @Description:
 */
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public User test(@RequestBody User user) {
        //反参
        return user;
    }
}
