package com.shenxian.common;

import lombok.Data;

/**
 * 统一返回
 * @Author: shenxian
 * @Date: 2021/7/23 11:21
 */
@Data
public class RespBean {

    private boolean success;
    private long code;
    private String message;
    private Object data;

    private RespBean() {}

    /**
     * 成功返回
     * @return
     */
    public static RespBean success() {
        RespBean respBean = new RespBean();
        respBean.setSuccess(true);
        respBean.setCode(200);
        respBean.setMessage("成功");
        return respBean;
    }

    /**
     * 失败返沪
     * @return
     */
    public static RespBean error() {
        RespBean respBean = new RespBean();
        respBean.setSuccess(false);
        respBean.setCode(500);
        respBean.setMessage("失败");
        return respBean;
    }

    public RespBean success(boolean success) {
        this.success = success;
        return this;
    }

    public RespBean code(long code) {
        this.code = code;
        return this;
    }

    public RespBean message(String message) {
        this.message = message;
        return this;
    }

    public RespBean data(Object data) {
        this.data = data;
        return this;
    }

}
