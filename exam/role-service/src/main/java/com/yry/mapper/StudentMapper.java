package com.yry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yry.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
