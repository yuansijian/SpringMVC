package admin.service;

import admin.generator.entity.Uploadfile;

import java.util.List;

public interface UploadfileService
{
    int insert(Uploadfile record);

    List<Uploadfile> queryAll();

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uploadfile record);

    List<Uploadfile> fuzzyQuery(String fileName, String startTime, String endTime);
}
