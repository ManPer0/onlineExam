package com.yry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Message;
import com.yry.mapper.MessageMapper;
import com.yry.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper,Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

//    public IPage<Message> findAll(Page<Message> page) {
//        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.orderByDesc(Message::getId);
//        return messageMapper.selectPage(page,queryWrapper);
//    }

    @Override
    public IPage<Message> findAll(Page page) {
        return messageMapper.findAll(page);
    }

    public Message findById(Integer id) {
        return messageMapper.selectById(id);
    }

    public int delete(Integer id) {
        return messageMapper.deleteById(id);
    }

    public int update(Message message) {
        return messageMapper.updateById(message);
    }

    public int add(Message message) {
        System.out.println("----------------------********************--------------------"+message.getId());

        return messageMapper.insert(message);
    }
}
