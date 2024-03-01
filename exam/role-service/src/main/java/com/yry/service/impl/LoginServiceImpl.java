package com.yry.service.impl;

import com.yry.entity.Admin;
import com.yry.entity.Student;
import com.yry.entity.Teacher;
import com.yry.service.AdminService;
import com.yry.service.LoginService;
import com.yry.service.StudentService;
import com.yry.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminService adminLogin;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return adminLogin.adminLogin(username, password);
    }
    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return teacherService.teacherLogin(username, password);
    }
    @Override
    public Student studentLogin(Long username, String password) {
        return studentService.studentLogin(username, password);
    }
}
