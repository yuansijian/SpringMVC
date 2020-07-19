package admin.service;

import admin.generator.entity.Loginnumber;

import java.util.List;

public interface LoginnumberService
{
    Loginnumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loginnumber record);


}
