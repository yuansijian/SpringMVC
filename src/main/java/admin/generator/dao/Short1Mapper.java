package admin.generator.dao;

import admin.generator.entity.Short1;
import admin.generator.entity.Short1WithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Short1Mapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Short1WithBLOBs record);

    int insertSelective(Short1WithBLOBs record);

    Short1WithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Short1WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(Short1WithBLOBs record);

    int updateByPrimaryKey(Short1 record);

    List<Short1WithBLOBs> queryAll();

    List<Short1WithBLOBs> fuzzyQuery(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("keyword") String keyword);
}