package com.yry.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Data
@Component
public class Student implements Serializable {
    @TableId(value = "student_id",type = IdType.AUTO)//在自增主键的变量加上即可
    private Long studentId;

    private String studentName;

    private String grade;

    private String major;

    private String clazz;

    private String institute;

    private String tel;

    private String email;

    private String pwd;

    private String cardId;

    private String sex;

    private String role;
}
