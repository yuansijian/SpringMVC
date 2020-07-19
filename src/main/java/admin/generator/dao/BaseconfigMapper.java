package admin.generator.dao;

import admin.generator.entity.Baseconfig;
import admin.generator.entity.BaseconfigWithBLOBs;

public interface BaseconfigMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(BaseconfigWithBLOBs record);

    int insertSelective(BaseconfigWithBLOBs record);

    BaseconfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseconfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BaseconfigWithBLOBs record);

    int updateByPrimaryKey(Baseconfig record);
}