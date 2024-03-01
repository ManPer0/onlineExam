package com.yry.filter;

import com.alibaba.fastjson.JSON;
import com.yry.entity.*;
import com.yry.util.IdentUtils;
import com.yry.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    private List<SimpleGrantedAuthority> authorities;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //获取token
        String requestTokenHeader = request.getHeader("Authorization");
        if (!StringUtils.hasText(requestTokenHeader)){
            System.out.println("无token");
//            response.sendRedirect("https://www.baidu.com/");
            filterChain.doFilter(request,response);
            return;
        }
        String token;
        String prefix = "Bearer ";
        if (requestTokenHeader.startsWith(prefix)) { // 确保token是Bearer类型。
            try {
                token = requestTokenHeader.substring(prefix.length());
                if (token.equals("null")){
                    System.out.println("无token");
//            response.sendRedirect("https://www.baidu.com/");
                    filterChain.doFilter(request,response);
                    return;
                }
                System.out.println(token.getClass());
            } catch (Exception e) {
                // 处理token无效的情况，例如返回401。
                throw new RuntimeException("token非法");
            }
        } else {
            // 处理没有token的情况，例如返回401。
            throw new RuntimeException("token非法");
        }

        //解析token
        String userId;
        try {
            userId = JwtUtils.getUsernameFromJwtToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //redis操作

        LoginR userInfoR = null;

        if (userId.length()<=4){
            userInfoR = (LoginR<Admin>) redisTemplate.opsForValue().get(IdentUtils.ADMIN+userId);
        }
        if (userId.length()>9){
            userInfoR = (LoginR<Student>) redisTemplate.opsForValue().get(IdentUtils.STUDENT + userId);
//            System.out.println(redisTemplate.opsForValue().get(IdentUtils.STUDENT + userId));
        }
        if (userId.length()>4 && userId.length()<=9){
            userInfoR = (LoginR<Teacher>) redisTemplate.opsForValue().get(IdentUtils.TEACHER+userId);
        }
        System.out.println(userInfoR+"----------------------------94------------------------------------");
        if (Objects.isNull(userInfoR)){
            throw new RuntimeException("用户未登录");
        }
        Login loginUser = new Login(userInfoR);
        //存入securityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(new Login(userInfoR),null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
