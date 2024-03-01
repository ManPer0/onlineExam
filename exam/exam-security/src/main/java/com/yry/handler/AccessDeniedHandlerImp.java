package com.yry.handler;

import com.alibaba.fastjson.JSON;
import com.yry.entity.R;
import com.yry.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessDeniedHandlerImp implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        R<String> backData = new R<String>(HttpStatus.FORBIDDEN.value(),"您的权限不足");
        System.out.println("您的权限不足");
        WebUtils.renderString(response, JSON.toJSONString(backData));
    }
}
