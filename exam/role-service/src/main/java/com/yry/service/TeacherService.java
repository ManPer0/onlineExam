package com.yry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.entity.Teacher;

public interface TeacherService extends IService<Teacher> {
    Teacher teacherLogin(Integer username, String password);
}
