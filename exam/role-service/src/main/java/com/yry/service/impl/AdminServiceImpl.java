package com.yry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Admin;
import com.yry.mapper.AdminMapper;
import com.yry.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<Admin> findAll() {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Admin::getAdminId, BaseContext.getCurrentId());
        return adminMapper.selectList(queryWrapper);
    }

    public Admin findById(Integer adminId) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getAdminId,adminId);
        return adminMapper.selectOne(queryWrapper);
    }

    public int deleteById(Integer adminId) {
        LambdaQueryWrapper<Admin> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(Admin::getAdminId,adminId);
        return adminMapper.delete(updateWrapper);
    }

    public int update(Admin admin) {
        LambdaUpdateWrapper<Admin> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(Admin::getAdminId,admin.getAdminId());
        if (adminMapper.update(admin,queryWrapper)>0){
            return admin.getAdminId();
        }
        return 0;
    }

    public int add(Admin admin) {
        if (adminMapper.insert(admin)>0){
            return admin.getAdminId();
        }

        return 0;
    }

    @Override
    public Admin adminLogin(Integer username, String password) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getAdminId,username).eq(Admin::getPwd,password);
        return adminMapper.selectOne(queryWrapper);
    }
}
