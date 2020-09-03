package com.securityoauth2jwt.demo.controller;

import com.securityoauth2jwt.demo.util.SessionUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {

    //打印当前的用户信息
    @GetMapping("/hello")
    public String hello() throws UnsupportedEncodingException {
        //保存在session中的username
        String username = SessionUtil.getCurrentUserName();

        //解析得到jwt中保存的用户信息
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request= attributes.getRequest();
        String jwtToken = request.getParameter("access_token");
        Claims body = Jwts.parser().setSigningKey("internet_plus".getBytes("UTF-8")).parseClaimsJws(jwtToken).getBody();
        String usernameinjwt = (String) body.get("user_name");
        //get roles
        ArrayList<String> authorities =  (ArrayList<String>)body.get("authorities");
        String roleList = "";
        for (String role : authorities) {
            if (roleList.equals("")) {
                roleList = role;
            } else {
                roleList += ","+role;
            }
        }
        String retstr = "username:"+username+";username in jwt:"+usernameinjwt+";role:"+roleList;
        String sessionInfo = "this is admin hello:"+retstr;
        return sessionInfo;
    }
}
