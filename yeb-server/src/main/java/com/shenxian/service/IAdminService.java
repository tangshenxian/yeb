package com.shenxian.service;

import com.shenxian.common.RespBean;
import com.shenxian.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shenxian.pojo.Menu;
import com.shenxian.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shenxian
 * @since 2021-07-23
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUsername(String name);

    List<Role> getRoles(Integer adminId);

}
