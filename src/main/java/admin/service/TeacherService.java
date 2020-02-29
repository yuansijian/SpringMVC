package admin.service;

import admin.generator.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService
{
    Teacher selectByPrimaryKey(Integer id);
    long selectByCountPrimaryKey();
    List<Teacher> queryAll();
    List<Teacher> queryFuzzyRegistered(String teaname, String startTime, String endTime);
    Teacher adminUpdateEdit(Integer id);
    int updateByPrimaryKeySelective(Teacher record);
    int deleteByPrimaryKey(Integer id);
    List<Teacher> queryRes(@Param("startTime")String startTime, @Param("endTime")String endTime);


}
