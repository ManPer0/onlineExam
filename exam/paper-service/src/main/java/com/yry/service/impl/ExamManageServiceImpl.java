package com.yry.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.ExamManage;
import com.yry.mapper.ExamManageMapper;
import com.yry.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl extends ServiceImpl<ExamManageMapper,ExamManage> implements ExamManageService {
//    @Autowired
//    private ExamManageMapper examManageMapper;
//
//
//    @Override
//    public List<ExamManage> findAll() {
//        return examManageMapper.findAll();
//    }
//
//    @Override
//    public IPage<ExamManage> findAll_(Page<ExamManage> page) {
//        return examManageMapper.findAll_(page);
//    }
//
//    @Override
//    public ExamManage findById(Integer examCode) {
//        return examManageMapper.findById(examCode);
//    }
//
//    @Override
//    public int delete(Integer examCode) {
//        return examManageMapper.delete(examCode);
//    }
//
//    @Override
//    public int update(ExamManage exammanage) {
//        return examManageMapper.update(exammanage);
//    }
//
//    @Override
//    public int add(ExamManage exammanage) {
//        return examManageMapper.add(exammanage);
//    }
//
//    @Override
//    public ExamManage findOnlyPaperId() {
//        return examManageMapper.findOnlyPaperId();
//    }
}
