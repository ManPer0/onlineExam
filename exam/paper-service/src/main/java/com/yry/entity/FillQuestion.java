package com.yry.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//填空题实体类
@Data
@Component
public class FillQuestion implements Serializable {
    @TableId(value = "question_id",type = IdType.AUTO)//在自增主键的变量加上即可
    private Integer questionId;

    private String subject;

    private String question;

    private String answer;

    private Integer score;

    private String level;

    private String section;

    private String analysis; //题目解析
}
