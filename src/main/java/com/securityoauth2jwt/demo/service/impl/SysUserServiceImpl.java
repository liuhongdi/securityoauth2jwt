package com.securityoauth2jwt.demo.service.impl;

import com.securityoauth2jwt.demo.mapper.UserMapper;
import com.securityoauth2jwt.demo.pojo.SysUser;
import com.securityoauth2jwt.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public SysUser getOneUserByUsername(String username) {
        System.out.println("begin query database:getOneUserByUsername");
        SysUser user_one = userMapper.selectOneUserByUserName(username);
        return user_one;
    }
}
