package admin.generator.dao;

import admin.generator.entity.Replygood;

public interface ReplygoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Replygood record);

    int insertSelective(Replygood record);

    Replygood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Replygood record);

    int updateByPrimaryKey(Replygood record);
}