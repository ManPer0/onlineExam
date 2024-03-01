package com.yry.service;


import com.yry.entity.Admin;
import com.yry.entity.Student;
import com.yry.entity.Teacher;

public interface LoginService {

    Admin adminLogin(Integer username, String password);

    Teacher teacherLogin(Integer username, String password);

    Student studentLogin(Long username, String password);
}
