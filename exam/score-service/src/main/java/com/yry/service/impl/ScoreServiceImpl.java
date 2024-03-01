package com.yry.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Score;
import com.yry.mapper.ScoreMapper;
import com.yry.service.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper,Score> implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public int add(Score score) {
        return scoreMapper.add(score);
    }

    @Override
    public List<Score> findAll() {
        return scoreMapper.findAll();
    }

    @Override
    public IPage<Score> findById_(Page page, String studentId) {
        System.out.println("findById_");
        return scoreMapper.findById_(page, studentId);
    }

    @Override
    public List<Score> findById(String studentId) {
        return scoreMapper.findById(studentId);
    }

    @Override
    public List<Score> findByExamCode(Integer examCode) {
        return scoreMapper.findByExamCode(examCode);
    }
}
