package com.yry.mapper;

import com.yry.entity.PaperManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperMapper {
    @Select("select paper_id, question_type,question_id from paper_manage")
    List<PaperManage> findAll();

    @Select("select paper_id, question_type,question_id from paper_manage where paper_id = #{paperId}")
    List<PaperManage> findById(Integer paperId);

    @Insert("insert into paper_manage(paper_id,question_type,question_id) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(PaperManage paperManage);
}
