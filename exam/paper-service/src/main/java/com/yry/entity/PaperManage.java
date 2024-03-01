package com.yry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PaperManage implements Serializable {
    private Integer paperId;

    private Integer questionType;

    private Integer questionId;


}
