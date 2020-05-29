package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.LoginLogMapper;
import com.mmz.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-cloud-mapping
 * @description: 登录日志
 * @author: Liu Xinpeng
 * @create: 2020-05-28 09:42
 **/
@Service
public class LoginLogService extends BaseService<LoginLog> {
    @Autowired
    private LoginLogMapper loginLogMapper;
}