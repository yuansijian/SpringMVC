package admin.service;

import admin.generator.entity.Uploadconfig;

public interface UploadconfigService
{
    Uploadconfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uploadconfig record);

    int updateByPrimaryKey(Uploadconfig record);

}
