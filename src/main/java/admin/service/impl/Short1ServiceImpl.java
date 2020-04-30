package admin.service.impl;

import admin.generator.dao.Short1Mapper;
import admin.generator.entity.Short1WithBLOBs;
import admin.service.Short1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 简答题库
 * @author: Yuan Sijian
 * @create: 2020-03-19 15:48
 **/
@Service
public class Short1ServiceImpl implements Short1Service
{
    @Autowired
    Short1Mapper short1Mapper;

    /**
    * @Description: 查找所有
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public List<Short1WithBLOBs> queryAll()
    {
        return short1Mapper.queryAll();
    }

    /**
    * @Description: 搜索功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public List<Short1WithBLOBs> fuzzyQuery(String startTime, String endTime, String keyword)
    {
        return short1Mapper.fuzzyQuery(startTime, endTime, keyword);
    }

    /**
    * @Description: 更新
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public int updateByPrimaryKeySelective(Short1WithBLOBs record)
    {
        return short1Mapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 新增图文教学
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public int insert(Short1WithBLOBs record)
    {
        return short1Mapper.insert(record);
    }

    /**
    * @Description: 通过主键精准查找
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public Short1WithBLOBs selectByPrimaryKey(Integer id)
    {
        return short1Mapper.selectByPrimaryKey(id);
    }
}
