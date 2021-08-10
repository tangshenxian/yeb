package com.shenxian.service.impl;

import com.shenxian.pojo.Department;
import com.shenxian.mapper.DepartmentMapper;
import com.shenxian.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shenxian
 * @since 2021-07-23
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
