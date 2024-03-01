package com.yry.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.entity.Admin;

public interface AdminService extends IService<Admin> {
    Admin adminLogin(Integer username, String password);
}
