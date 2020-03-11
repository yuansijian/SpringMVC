package admin.generator.dao;

import admin.generator.entity.Givehomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GivehomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Givehomework record);

    int insertSelective(Givehomework record);

    Givehomework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Givehomework record);

    int updateByPrimaryKeyWithBLOBs(Givehomework record);

    int updateByPrimaryKey(Givehomework record);

    List<Givehomework> queryAll();

    List<Givehomework> fuzzyQuery(@Param("homeworkname")String homeworkname, @Param("StartTime")String startTime, @Param("endTime")String endTime);
}