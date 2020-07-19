package admin.service;

import admin.generator.entity.Short1WithBLOBs;

import java.util.List;

public interface Short1Service
{
    List<Short1WithBLOBs> queryAll();

    List<Short1WithBLOBs> fuzzyQuery(String startTime, String endTime, String keyword);

    int updateByPrimaryKeySelective(Short1WithBLOBs record);

    int insert(Short1WithBLOBs record);

    Short1WithBLOBs selectByPrimaryKey(Integer id);


}
