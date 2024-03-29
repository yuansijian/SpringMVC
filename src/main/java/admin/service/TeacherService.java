package admin.service;

import admin.generator.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
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

    List<Teacher> queryRes(String startTime, String endTime);

    int queryCountLogin(String startTime, String endTime);

    int insert(Teacher record);

    List<Teacher> checkTea();

    Teacher queryUsernameAndPassword(String username, String password);


}
