package com.securityoauth2jwt.demo.mapper;

import com.securityoauth2jwt.demo.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    public SysUser selectOneUserByUserName(String username);
}