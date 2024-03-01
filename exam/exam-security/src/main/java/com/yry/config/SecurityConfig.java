package com.yry.config;

import com.yry.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final static String[] URL_WHITELIST = {
            "/login","/admins","/test"
    };
    @Resource
    private JwtAuthenticationTokenFilter tokenFilter;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    //密文加密
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder(10);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
//        //使用基于内存的认证配置
//        auth.inMemoryAuthentication()
//                //定义用户名为"user"的用户
//                .withUser("user")
//                //使用 passwordEncoder() bean 设置用户的加密密码
//                .password(bCryptPasswordEncoder().encode("password"))
//                //为用户分配 "USER" 角色
//                .roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //开启跨域 以及csrf攻击 关闭
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //无状态
                .and()
                .formLogin()
                .loginPage("/") // 指定登录页面的URL
                .permitAll()  // 允许任何人访问登录页面
                //拦截规则配置和自定义登录界面
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll() //白名单 放行
                .anyRequest().authenticated();
        //将token过滤器放在UsernamePasswordAuthenticationFilter之前运行    （过滤器）
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        //配置处理器
        http.exceptionHandling()
                //认证失败
                .authenticationEntryPoint(authenticationEntryPoint)
//                权限不足
                .accessDeniedHandler(accessDeniedHandler);
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }



}
