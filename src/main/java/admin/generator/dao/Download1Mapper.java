package admin.generator.dao;

import admin.generator.entity.Download1;

public interface Download1Mapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Download1 record);

    int insertSelective(Download1 record);

    Download1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Download1 record);

    int updateByPrimaryKey(Download1 record);
}