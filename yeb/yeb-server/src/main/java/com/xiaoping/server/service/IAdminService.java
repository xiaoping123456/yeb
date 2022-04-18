package com.xiaoping.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoping.server.pojo.Admin;
import com.xiaoping.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoping
 * @since 2022-04-16
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);
}
