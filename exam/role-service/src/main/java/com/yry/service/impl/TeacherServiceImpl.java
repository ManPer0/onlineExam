package com.yry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Teacher;
import com.yry.mapper.TeacherMapper;
import com.yry.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper,Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public IPage<Teacher> findAll_(Page<Teacher> page) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Teacher::getTeacherId);
        return teacherMapper.selectPage(page,queryWrapper);
    }

    public List<Teacher> findAll() {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Teacher::getTeacherId);
        return teacherMapper.selectList(queryWrapper);
    }

    public Teacher findById(Integer teacherId) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teacher::getTeacherId,teacherId);
        return teacherMapper.selectOne(queryWrapper);
    }

    public int deleteById(Integer teacherId) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teacher::getTeacherId,teacherId);
        return teacherMapper.delete(queryWrapper);
    }

    public int update(Teacher teacher) {
        LambdaUpdateWrapper<Teacher> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Teacher::getTeacherId,teacher.getTeacherId());
        return teacherMapper.update(teacher,updateWrapper);
    }

    public int add(Teacher teacher) {
        teacher.setPwd(DigestUtils.md5DigestAsHex(teacher.getPwd().getBytes()));
        return teacherMapper.insert(teacher);
    }

    @Override
    public Teacher teacherLogin(Integer username, String password) {
        LambdaQueryWrapper<Teacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teacher::getTeacherId,username).eq(Teacher::getPwd,password);
        return teacherMapper.selectOne(queryWrapper);
    }
}
