package com.yry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yry.entity.Message;

public interface MessageService extends IService<Message> {
    IPage<Message> findAll(Page page);

//    Message findById(Integer id);
//
//    int delete(Integer id);
//
//    int update(Message message);
//
//    int add(Message message);
}
