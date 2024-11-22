package com.ly.enums;

import com.ly.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: dly
 * @Date: 2024-11-22-23:17
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错了"),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "产品不存在"),

    PARAM_NOT_VALID("10001", "参数错误"),
    ;
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;
}
