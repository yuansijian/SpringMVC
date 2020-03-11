package admin.generator.dao;

import admin.generator.entity.Homework;
import admin.generator.entity.HomeworkWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeworkWithBLOBs record);

    int insertSelective(HomeworkWithBLOBs record);

    HomeworkWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HomeworkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HomeworkWithBLOBs record);

    int updateByPrimaryKey(Homework record);

    List<HomeworkWithBLOBs> queryAll();

    List<HomeworkWithBLOBs> fuzzyQuery(@Param("stuname")String stuname, @Param("homeworkname")String homeworkname, @Param("startTime")String startTime, @Param("endTime")String endTime);
}