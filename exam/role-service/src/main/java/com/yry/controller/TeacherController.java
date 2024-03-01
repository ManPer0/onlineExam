package com.yry.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yry.entity.ApiResult;
import com.yry.entity.Teacher;
import com.yry.service.impl.TeacherServiceImpl;
import com.yry.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherService){
        this.teacherService = teacherService;
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1')")
    @GetMapping("/teachers/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);
        IPage<Teacher> teacherIPage = teacherService.findAll_(teacherPage);

        return ApiResultHandler.buildApiResult(200,"查询所有教师",teacherIPage);
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1')")
    @GetMapping("/teacher/{teacherId}")
    public ApiResult findById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.findById(teacherId));
    }
//    @PreAuthorize("hasAuthority('0') || hasAuthority('1')")
    @DeleteMapping("/teacher/{teacherId}")
    public ApiResult deleteById(@PathVariable("teacherId") Integer teacherId){
        return ApiResultHandler.success(teacherService.deleteById(teacherId));
    }
//    @PreAuthorize("hasAuthority('0')")
    @PutMapping("/teacher")
    public ApiResult update(@RequestBody Teacher teacher){
        if (!Objects.isNull(teacher.getPwd())){
            teacher.setPwd(DigestUtils.md5DigestAsHex(teacher.getPwd().getBytes()));
        }
        return ApiResultHandler.success(teacherService.update(teacher));
    }
//    @PreAuthorize("hasAuthority('0')")
    @PostMapping("/teacher")
    public ApiResult add(@RequestBody Teacher teacher){
        return ApiResultHandler.success(teacherService.add(teacher));
    }
}
