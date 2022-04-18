package com.xiaoping.server.service.impl;

import com.xiaoping.server.pojo.Employee;
import com.xiaoping.server.mapper.EmployeeMapper;
import com.xiaoping.server.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoping
 * @since 2022-04-16
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
