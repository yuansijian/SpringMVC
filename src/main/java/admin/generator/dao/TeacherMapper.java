package admin.generator.dao;

import admin.generator.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    List<Teacher> queryAll();

    List<Teacher> queryFuzzyRegistered(@Param("teaname") String teaname, @Param("startTime")String startTime, @Param("endTime") String endTime);

    int insert(Teacher record);

    long selectByCountPrimaryKey();

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKeyWithBLOBs(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher adminUpdateEdit(Integer id);

    List<Teacher> queryRes(@Param("startTime")String startTime, @Param("endTime")String endTime);

    int queryCountLogin(@Param("startTime")String startTime, @Param("endTime")String endTime);
}