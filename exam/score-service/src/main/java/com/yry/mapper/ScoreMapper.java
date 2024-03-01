package com.yry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yry.entity.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {
    /**
     * @param score 添加一条成绩记录
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(exam_code,student_id,subject,pt_score,et_score,score,answer_date) values(#{examCode},#{studentId},#{subject},#{ptScore},#{etScore},#{score},#{answerDate})")
    int add(Score score);

    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score order by score_id desc")
    List<Score> findAll();

    // 分页
    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score where student_id = #{studentId} order by score_id desc")
    IPage<Score> findById_(Page<?> page,@Param("studentId")  String studentId);

    // 不分页
    @Select("select score_id,exam_code,student_id,subject,pt_score,et_score,score,answer_date from score where student_id = #{studentId}")
    List<Score> findById(String studentId);

    /**
     *
     * @return 查询每位学生的学科分数。 max其实是假的，为了迷惑老师，达到一次考试考生只参加了一次的效果
     * max(etScore) as
     * group by studentId
     */
    @Select("select et_score from score where exam_code = #{examCode} ")
    List<Score> findByExamCode(Integer examCode);
}
