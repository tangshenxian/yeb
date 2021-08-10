package com.shenxian.service;

import com.shenxian.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shenxian.pojo.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shenxian
 * @since 2021-07-23
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusByAdminId();

    List<Menu> getMenusWithRole();

}
