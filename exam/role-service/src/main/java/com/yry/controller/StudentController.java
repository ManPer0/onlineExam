package com.yry.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yry.entity.ApiResult;
import com.yry.entity.Student;
import com.yry.service.impl.StudentServiceImpl;
import com.yry.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
//@PreAuthorize("hasAuthority('0') || hasAuthority('1')")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

//    @PreAuthorize("hasAuthority('0') || hasAuthority('1') || hasAuthority('2')")
    @GetMapping("/students/{page}/{size}")
    public ApiResult findAll_(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Student> studentPage = new Page<>(page,size);
        IPage<Student> res = studentService.findAll_(studentPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有学生",res);
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1') || hasAuthority('2')")
    @GetMapping("/student/{studentId}")
    public ApiResult findById(@PathVariable("studentId") String studentId) {
        Student res = studentService.findById(studentId);
        if (res != null) {
        return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
        }
    }

    @DeleteMapping("/student/{studentId}")
    public ApiResult deleteById(@PathVariable("studentId") String studentId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",studentService.deleteById(studentId));
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1') || hasAuthority('2')")
    @PutMapping("/studentPWD")
    public ApiResult updatePwd(@RequestBody Student student) {
        student.setPwd(DigestUtils.md5DigestAsHex(student.getPwd().getBytes()));
        studentService.updatePwd(student);
        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1') || hasAuthority('2')")
    @PutMapping("/student")
    public ApiResult update(@RequestBody Student student) {
        int res = studentService.update(student);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/student")
    public ApiResult add(@RequestBody Student student) {
        student.setPwd(DigestUtils.md5DigestAsHex(student.getPwd().getBytes()));
        int res = studentService.add(student);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }
}
