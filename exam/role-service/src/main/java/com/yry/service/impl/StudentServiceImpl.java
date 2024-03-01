package com.yry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Student;
import com.yry.mapper.StudentMapper;
import com.yry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    public IPage<Student> findAll_(Page<Student> page) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Student::getStudentId);
        return studentMapper.selectPage(page,queryWrapper);
    }

    public Student findById(String studentId) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentId,studentId);
        return studentMapper.selectOne(queryWrapper);
    }

    public int deleteById(String studentId) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentId,studentId);
        return studentMapper.delete(queryWrapper);
    }

    public int update(Student student) {
        LambdaUpdateWrapper<Student> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Student::getStudentId,student.getStudentId());
        return studentMapper.update(student,updateWrapper);
    }

    public int updatePwd(Student student) {
        LambdaUpdateWrapper<Student> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Student::getStudentId,student.getStudentId());
        return studentMapper.update(student,updateWrapper);
    }

    public int add(Student student) {
        student.setPwd(DigestUtils.md5DigestAsHex(student.getPwd().getBytes()));
        return studentMapper.insert(student);
    }

    @Override
    public Student studentLogin(Long username, String password) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentId,username).eq(Student::getPwd,password);
        return studentMapper.selectOne(queryWrapper);
    }
}
