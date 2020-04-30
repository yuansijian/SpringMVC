package admin.service.impl;

import admin.generator.dao.GivehomeworkMapper;
import admin.generator.entity.Givehomework;
import admin.service.GivehomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 作业列表
 * @author: Yuan Sijian
 * @create: 2020-03-11 22:26
 **/
@Service
public class GivehomeworkServiceImpl implements GivehomeworkService
{
    @Autowired
    GivehomeworkMapper givehomeworkMapper;

    /**
    * @Description: 查找所有
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public List<Givehomework> queryAll()
    {
        return givehomeworkMapper.queryAll();
    }

    /**
    * @Description: 搜索功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public List<Givehomework> fuzzyQuery(String homeworkname, String startTime, String endTime)
    {
        return givehomeworkMapper.fuzzyQuery(homeworkname, startTime, endTime);
    }

    /**
    * @Description: 新增作业
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public int insert(Givehomework record)
    {
        return givehomeworkMapper.insert(record);
    }

    /**
    * @Description: 作业更新
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public int updateByPrimaryKeySelective(Givehomework record)
    {
        return givehomeworkMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 作业精准查找
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public Givehomework selectByPrimaryKey(Integer id)
    {
        return givehomeworkMapper.selectByPrimaryKey(id);
    }
}
