package com.yry.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yry.entity.ApiResult;
import com.yry.entity.ExamManage;
import com.yry.service.impl.ExamManageServiceImpl;
import com.yry.util.ApiResultHandler;
import com.yry.util.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ExamManageController {

    @Autowired
    private ExamManageServiceImpl examManageService;

    @GetMapping("/exams")
    public ApiResult findAll(){
        System.out.println("不分页查询所有试卷");
        LambdaQueryWrapper<ExamManage> examManageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        return ApiResultHandler.buildApiResult(200, "请求成功！", examManageService.list(examManageLambdaQueryWrapper));
    }

    @GetMapping("/exams/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        System.out.println("分页查询所有试卷");
        Page<ExamManage> examManage = new Page<>(page,size);
        examManageService.page(examManage);
        return ApiResultHandler.buildApiResult(200, "请求成功！", examManage);
    }

    @GetMapping("/exam/{examCode}")
    public ApiResult findById(@PathVariable("examCode") Integer examCode){
        System.out.println("根据ID查找");
        LambdaQueryWrapper<ExamManage> examManageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        examManageLambdaQueryWrapper.eq(ExamManage::getExamCode,examCode);
        ExamManage res = examManageService.getOne(examManageLambdaQueryWrapper);
        if(res == null) {
            return ApiResultHandler.buildApiResult(10000,"考试编号不存在",null);
        }
        return ApiResultHandler.buildApiResult(200,"请求成功！",res);
    }

    @DeleteMapping("/exam/{examCode}")
    public ApiResult deleteById(@PathVariable("examCode") Integer examCode){
        LambdaQueryWrapper<ExamManage> examManageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        examManageLambdaQueryWrapper.eq(ExamManage::getExamCode,examCode);
        if(examManageService.remove(examManageLambdaQueryWrapper)){
            return ApiResultHandler.buildApiResult(200,"删除成功",examCode);
        }
        return ApiResultHandler.buildApiResult(400,"删除失败",examCode);
    }

    @PutMapping("/exam")
    public ApiResult update(@RequestBody ExamManage exammanage){
        LambdaUpdateWrapper<ExamManage> examManageLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        examManageLambdaUpdateWrapper.setEntity(exammanage);
//        int res = ;
        System.out.print("更新操作执行---");
        if (examManageService.update(examManageLambdaUpdateWrapper)){
            return ApiResultHandler.buildApiResult(200,"更新成功",exammanage.getExamCode());
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",exammanage.getExamCode());
    }

    @PostMapping("/exam")
    public ApiResult add(@RequestBody ExamManage exammanage){

        if (examManageService.save(exammanage)) {
            return ApiResultHandler.buildApiResult(200, "添加成功", exammanage.getExamCode());
        } else {
            return  ApiResultHandler.buildApiResult(400,"添加失败",exammanage.getExamCode());
        }
    }

    @GetMapping("/examManagePaperId")
    public ApiResult findOnlyPaperId() {
        LambdaQueryWrapper<ExamManage> examManageLambdaQueryWrapper = new LambdaQueryWrapper<>();
        examManageLambdaQueryWrapper.orderByDesc(ExamManage::getPaperId);
        examManageLambdaQueryWrapper.last("limit 0,1");
        ExamManage res = examManageService.getOne(examManageLambdaQueryWrapper);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败",res);
    }
}
