package com.shenxian.controller;

import com.shenxian.common.RespBean;
import com.shenxian.pojo.Admin;
import com.shenxian.pojo.AdminLoginParam;
import com.shenxian.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @Author: shenxian
 * @Date: 2021/7/24 9:43
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(HttpServletRequest request, @RequestBody AdminLoginParam adminLoginParam) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), adminLoginParam.getCode(), request);
    }

    @ApiOperation(value = "获取当前登陆用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String name = principal.getName();
        Admin admin = adminService.getAdminByUsername(name);
        if (admin == null) {
            return null;
        }
        admin.setPassword(null);
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success();
    }
}
