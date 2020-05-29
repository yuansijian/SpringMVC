package admin.generator.dao;

import admin.generator.entity.Loginnumber;

public interface LoginnumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loginnumber record);

    int insertSelective(Loginnumber record);

    Loginnumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginnumber record);

    int updateByPrimaryKey(Loginnumber record);
}