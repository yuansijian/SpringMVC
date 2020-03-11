package admin.service;

import admin.generator.entity.BaseconfigWithBLOBs;

public interface BaseconfigService
{
    BaseconfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseconfigWithBLOBs record);
}
