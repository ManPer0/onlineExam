package com.yry.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yry.entity.JudgeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//判断题

@Mapper
public interface JudgeQuestionMapper {

    @Select("select * from judge_question where question_id in (select question_id from paper_manage where question_type = 3 and paper_id = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    @Select("select * from judge_question")
    IPage<JudgeQuestion> findAll(Page page);

    /**
     * 查询最后一条记录的questionId
     * @return JudgeQuestion
     */
    @Select("select question_id from judge_question order by question_id desc limit 1")
    JudgeQuestion findOnlyQuestionId();

    @Insert("insert into judge_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(JudgeQuestion judgeQuestion);

    @Select("select question_id from judge_question  where subject=#{subject}  order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject,@Param("pageNo") Integer pageNo);
}
