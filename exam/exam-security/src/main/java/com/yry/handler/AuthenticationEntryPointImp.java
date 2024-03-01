package com.yry.handler;

import com.alibaba.fastjson.JSON;
import com.yry.entity.R;
import com.yry.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImp implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        R<String> backData;
        System.out.println(authException.getClass().getSimpleName());
        backData = new R<String>(HttpStatus.UNAUTHORIZED.value(),"用户认证错误");
        if ("InternalAuthenticationServiceException".equals(authException.getClass().getSimpleName())
                || "BadCredentialsException".equals(authException.getClass().getSimpleName())){
            backData = new R<String>(HttpStatus.UNAUTHORIZED.value(),"用户账号或密码认证错误");
        }
        System.out.println("认证失败");
        WebUtils.renderString(response, JSON.toJSONString(backData));
    }
}
