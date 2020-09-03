package com.securityoauth2jwt.demo.oauth2;

import com.securityoauth2jwt.demo.result.RestResult;
import com.securityoauth2jwt.demo.util.ServletUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("restAccessDeniedHandler")
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    //处理权限不足的情况:403,对应:access_denied
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        System.out.println("-------RestAccessDeniedHandler");
        ServletUtil.printRestResult(RestResult.error(403,"权限不够访问当前资源，被拒绝"));
    }
}