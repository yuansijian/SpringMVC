package admin.service;

import admin.generator.entity.Givehomework;

import java.util.List;

public interface GivehomeworkService
{
    List<Givehomework> queryAll();

    List<Givehomework> fuzzyQuery(String homeworkname, String startTime, String endTime);

    int insert(Givehomework record);

    int updateByPrimaryKeySelective(Givehomework record);

    Givehomework selectByPrimaryKey(Integer id);


}
