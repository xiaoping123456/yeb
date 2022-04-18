package com.xiaoping.server.service.impl;

import com.xiaoping.server.pojo.Department;
import com.xiaoping.server.mapper.DepartmentMapper;
import com.xiaoping.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
