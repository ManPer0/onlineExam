package com.yry.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

//判断题实体类
@Data
@Component
public class JudgeQuestion implements Serializable {
    private Integer questionId;

    private String subject;

    private String question;

    private String answer;

    private String level;

    private String section;

    private Integer score;

    private String analysis; //题目解析
}
