package com.yry.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Component
public class Message implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(exist = false)
    private Integer temp_id;//解决id为null创建的一个临时id

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date time;
    @TableField(exist = false)
    List<Replay> replays;   //一对多关系，评论信息
}
