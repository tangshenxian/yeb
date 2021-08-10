package com.shenxian.exception;

import com.shenxian.common.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author: shenxian
 * @Date: 2021/8/2 16:29
 */
@RestControllerAdvice(basePackages = "com.shenxian.controller")
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error().message("该数据有关联数据，操作失败");
        }
        return RespBean.error().message("数据库异常，操作失败");
    }

}
