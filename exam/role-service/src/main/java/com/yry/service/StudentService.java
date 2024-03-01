package com.yry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.entity.Student;

public interface StudentService extends IService<Student> {
    Student studentLogin(Long username, String password);
}
