package admin.generator.dao;

import admin.generator.entity.Uploadconfig;

public interface UploadconfigMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Uploadconfig record);

    int insertSelective(Uploadconfig record);

    Uploadconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uploadconfig record);

    int updateByPrimaryKeyWithBLOBs(Uploadconfig record);

    int updateByPrimaryKey(Uploadconfig record);
}