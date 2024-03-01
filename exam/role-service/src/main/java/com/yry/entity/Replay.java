package com.yry.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Replay implements Serializable {
    private Integer messageId;
    @TableId(value = "replay_id",type = IdType.AUTO)//在自增主键的变量加上即可
    private Integer replayId;

    private String replay;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date replayTime;
}
