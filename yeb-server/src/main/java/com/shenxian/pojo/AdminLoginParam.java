package com.shenxian.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: shenxian
 * @Date: 2021/7/24 9:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AdminLoginParam对象", description="")
public class AdminLoginParam {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    private String code;

}
