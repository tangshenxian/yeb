package com.shenxian.controller;

import com.shenxian.common.RespBean;
import com.shenxian.pojo.Role;
import com.shenxian.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限组控制
 * @Author: shenxian
 * @Date: 2021/8/5 14:11
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRole() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)) {
            return RespBean.success().message("添加成功");
        }
        return RespBean.error().message("添加失败");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable("rid") Integer rid) {
        if (roleService.removeById(rid)) {
            return RespBean.success().message("删除成功");
        }
        return RespBean.error().message("删除失败");
    }

}
