package com.yry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yry.entity.Replay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplayMapper extends BaseMapper<Replay> {

//    @Select("select messageId,replayId,replay,replayTime from replay")
//    List<Replay> findAll();
//
    @Select("select message_id,replay_id,replay,replay_time from replay where message_id = #{messageId}")
    List<Replay> findAllById(Integer messageId);

//    @Select("select messageId,replayId,replay,replayTime from replay where messageId = #{messageId}")
//    Replay findById(Integer messageId);
//
//    @Delete("delete from replay where replayId = #{replayId}")
//    int delete(Integer replayId);
//
//    @Update("update replay set title = #{title}, replay = #{replay}, replayTime = #{replayTime} where replayId = #{replayId}")
//    int update(Replay replay);
//
//    @Options(useGeneratedKeys = true,keyProperty = "replayId")
//    @Insert("insert into replay(messageId,replay,replayTime) values(#{messageId}, #{replay},#{replayTime})")
//    int add(Replay replay);
}
