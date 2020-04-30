package admin.service.impl;

import admin.generator.dao.Classes1Mapper;
import admin.generator.entity.Classes1;
import admin.service.Classes1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 班级年级
 * @author: Yuan Sijian
 * @create: 2020-03-18 15:53
 **/
@Service
public class Classes1ServiceImpl implements Classes1Service
{
    @Autowired
    Classes1Mapper classes1Mapper;
    /**
    * @Description: 查找所有
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public List<Classes1> queryAll()
    {
        return classes1Mapper.queryAll();
    }

    /**
    * @Description: 年级班级
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public List<String> queryClass()
    {
        return classes1Mapper.queryClass();
    }

    /**
    * @Description: 搜索功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public List<Classes1> fuzzyQuery(String keyword)
    {
        return classes1Mapper.fuzzyQuery(keyword);
    }

    /**
    * @Description: 插入
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public int insert(Classes1 record)
    {
        return classes1Mapper.insert(record);
    }

    /**
    * @Description: 更新
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public int updateByPrimaryKeySelective(Classes1 record)
    {
        return classes1Mapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 通过id查找
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-18
    */
    @Override
    public Classes1 selectByPrimaryKey(Integer id)
    {
        return classes1Mapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 查找已启用的年级班级,用于注册选择
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public List<Classes1> queryUsed()
    {
        return classes1Mapper.queryUsed();
    }
}
