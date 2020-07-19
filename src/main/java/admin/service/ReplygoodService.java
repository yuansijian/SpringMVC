package admin.service;

import admin.generator.entity.Replygood;

import java.util.List;

public interface ReplygoodService
{
    int insert(Replygood record);

    Replygood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Replygood record);

    Replygood existId(int uid, int cid);

    List<Replygood> queryAll();

}
