package com.ly.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: dly
 * @Date: 2024-11-19-23:39
 * @Description:
 */
@Data
public class User {
    //用户名
    @NotNull(message = "用户名不能为空")
    private String username;
    //性别
    @NotNull(message = "性别不能为空")
    private Integer sex;
    //年龄
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 120, message = "年龄不能大于120")
    private Integer age;
    //邮箱
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    // 创建时间
    private LocalDateTime createTime;
    // 更新日期
    private LocalDate updateDate;
    // 时间
    private LocalTime time;
}
