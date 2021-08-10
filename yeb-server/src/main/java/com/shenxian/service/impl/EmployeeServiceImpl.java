package com.shenxian.service.impl;

import com.shenxian.pojo.Employee;
import com.shenxian.mapper.EmployeeMapper;
import com.shenxian.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
