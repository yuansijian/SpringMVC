package admin.service;

import admin.generator.entity.Download1;

public interface Download1Service
{
    Download1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Download1 record);

}
