package com.ly.controller;

import com.ly.aspect.ApiOperationLog;
import com.ly.enums.ResponseCodeEnum;
import com.ly.exception.BizException;
import com.ly.model.User;
import com.ly.utils.JsonUtil;
import com.ly.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


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

    @PostMapping("/test2")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user, BindingResult bindingResult) {
        // 是否存在校验错误
        if (bindingResult.hasErrors()) {
            // 获取校验不通过字段的提示信息
            String errorMsg = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            return Response.fail(errorMsg);
        }

        // 返参
        return Response.success(user);
    }

    @PostMapping("/test3")
    @ApiOperationLog(description = "测试接口")
    public Response test3(@RequestBody @Validated User user, BindingResult bindingResult) {
        // 手动抛异常，入参是前面定义好的异常码枚举，返参统一交给全局异常处理器搞定
        throw new BizException(ResponseCodeEnum.PRODUCT_NOT_FOUND);
    }

    @PostMapping("/test4")
    @ApiOperationLog(description = "测试接口")
    public Response test4(@RequestBody @Validated User user, BindingResult bindingResult) {
        // 主动定义一个运行时异常，分母不能为零
        int i = 1 / 0;
        return Response.success();
    }

    @PostMapping("/test5")
    @ApiOperationLog(description = "测试接口")
    public Response test5(@RequestBody @Validated User user) {
        return Response.success();
    }
}
