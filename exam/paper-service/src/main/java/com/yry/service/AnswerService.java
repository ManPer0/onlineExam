package com.yry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.mapper.AnswerMapper;
import com.yry.vo.AnswerVO;

public interface AnswerService extends IService<AnswerVO> {

    IPage<AnswerVO> findAll(Page<AnswerVO> page);
}
