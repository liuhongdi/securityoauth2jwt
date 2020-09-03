package com.securityoauth2jwt.demo.service;

import com.securityoauth2jwt.demo.pojo.SysUser;

public interface SysUserService {
    public SysUser getOneUserByUsername(String Username);
}
