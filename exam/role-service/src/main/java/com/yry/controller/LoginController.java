package com.yry.controller;

import com.yry.entity.*;
import com.yry.service.impl.LoginServiceImpl;
import com.yry.util.ApiResultHandler;
import com.yry.util.IdentUtils;
import com.yry.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Collections;

import static com.yry.util.IdentUtils.SAVE_HOURS;


@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    AuthenticationManager authenticationManager;
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @DeleteMapping("/logout/{username}")
    public ApiResult logout(@PathVariable("username") String username){
        System.out.println(username);
        boolean judge = false;
        if (username.length()<=4){
           judge = redisTemplate.delete("admin-"+username);
        }else if (username.length()>=11){
            judge = redisTemplate.delete("student-"+username);
        }else {
            judge = redisTemplate.delete("teacher-"+username);
        }
        if (judge){
            return ApiResultHandler.success();
        }else {
            return ApiResult.error("登出失败");
        }
    }
    @PostMapping("/login")
    public ApiResult login(HttpServletResponse response, @RequestBody TransLogin login) {
        String username = login.getUsername();
        String password = DigestUtils.md5DigestAsHex(login.getPassword().getBytes());
        System.out.println(password);
        if (login.getUsername().length()<5){
            Admin adminRes = loginService.adminLogin(Integer.valueOf(username), password);
            System.out.println(adminRes+"____________________________________________________");
            if (adminRes != null) {
                System.out.println(new LoginR<>(new Login<>(adminRes, Collections.singletonList(adminRes.getRole()))));
                redisTemplate.opsForValue().set(IdentUtils.ADMIN+login.getUsername(), new LoginR<>(adminRes, Collections.singletonList(adminRes.getRole())),Duration.ofHours(SAVE_HOURS));
                response.setHeader("token", JwtUtils.generateJwtToken(login.getUsername()));
                return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
            }
        }
        if (login.getUsername().length()<9 && login.getUsername().length()>4){
            Teacher teacherRes = loginService.teacherLogin(Integer.valueOf(username), password);
            System.out.println(teacherRes);
            if (teacherRes != null) {
                redisTemplate.opsForValue().set(IdentUtils.TEACHER+login.getUsername(), new LoginR<>(teacherRes, Collections.singletonList(teacherRes.getRole())),Duration.ofHours(SAVE_HOURS));
                response.setHeader("token", JwtUtils.generateJwtToken(login.getUsername()));
                return ApiResultHandler.buildApiResult(200, "请求成功", teacherRes);
            }
        }
        if (login.getUsername().length()>9){
            Student studentRes = loginService.studentLogin(Long.valueOf(username),password);
            System.out.println(studentRes);
            if (studentRes != null) {
//                redisTemplate.opsForValue().set(IdentUtils.STUDENT+"-"+login.getUsername(), new LoginR<>(studentRes,Collections.singletonList(studentRes.getRole())),Duration.ofHours(SAVE_HOURS));
                redisTemplate.opsForValue().set(IdentUtils.STUDENT+login.getUsername(), new LoginR<>(studentRes,Collections.singletonList(studentRes.getRole())));
                response.setHeader("token", JwtUtils.generateJwtToken(login.getUsername()));
                return ApiResultHandler.buildApiResult(200, "请求成功", studentRes);
            }
        }
        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }
}
