package com.securityoauth2jwt.demo.oauth2;

import com.securityoauth2jwt.demo.result.RestResult;
import com.securityoauth2jwt.demo.util.ServletUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //返回未得到授权时的报错:对应:invalid_token
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException {
        //System.out.println("commence");
        ServletUtil.printRestResult(RestResult.error(401,"未得到授权"));
    }
}