package com.yry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yry.entity.Replay;
import com.yry.mapper.ReplayMapper;
import com.yry.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplayServiceImpl extends ServiceImpl<ReplayMapper,Replay> implements ReplayService {

    @Autowired
    private ReplayMapper replayMapper;

    public List<Replay> findAll() {
        LambdaQueryWrapper<Replay> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Replay::getMessageId);
        return replayMapper.selectList(queryWrapper);
    }

    public List<Replay> findAllById(Integer messageId) {
        LambdaQueryWrapper<Replay> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Replay::getMessageId,messageId);
        return replayMapper.selectList(queryWrapper);
    }

    public Replay findById(Integer replayId) {
        LambdaQueryWrapper<Replay> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Replay::getReplayId,replayId);
        return replayMapper.selectOne(queryWrapper);
    }

    public int delete(Integer replayId) {
        LambdaQueryWrapper<Replay> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Replay::getReplayId,replayId);
        return replayMapper.delete(queryWrapper);
    }

    public int update(Replay replay) {
        LambdaUpdateWrapper<Replay> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Replay::getReplayId,replay.getReplayId());
        return replayMapper.update(replay,updateWrapper);
    }

    public int add(Replay replay) {

        System.out.println(replay+"///////////////////////////-----------------------------");
        return replayMapper.insert(replay);
    }
}
