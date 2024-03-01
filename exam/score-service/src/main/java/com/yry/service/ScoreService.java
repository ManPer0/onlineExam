package com.yry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.entity.Score;

import java.util.List;

public interface ScoreService extends IService<Score> {
    int add(Score score);

    List<Score> findAll();

    IPage<Score> findById_(Page page, String studentId);

    List<Score> findById(String studentId);

    List<Score> findByExamCode(Integer examCode);
}
