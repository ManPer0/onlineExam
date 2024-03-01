package com.yry.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Admin implements Serializable {
    @TableId(value = "admin_id",type = IdType.AUTO)//在自增主键的变量加上即可
    private Integer adminId;

    private String adminName;

    private String sex;

    private String tel;

    private String email;

    private String pwd;

    private String cardId;

    private String role;
}
