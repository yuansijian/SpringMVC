package admin.service.impl;

import admin.generator.dao.HomeworkMapper;
import admin.generator.entity.HomeworkWithBLOBs;
import admin.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 作业提交
 * @author: Yuan Sijian
 * @create: 2020-03-11 21:28
 **/
@Service
public class HomeworkServiceImpl implements HomeworkService
{
    @Autowired
    HomeworkMapper homeworkMapper;
    /**
    * @Description: 查找作业
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public List<HomeworkWithBLOBs> queryAll()
    {
        return homeworkMapper.queryAll();
    }

    /**
    * @Description: 搜索功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-11
    */
    @Override
    public List<HomeworkWithBLOBs> fuzzyQuery(String stuname, String homeworkname, String startTime, String endTime)
    {
        return homeworkMapper.fuzzyQuery(stuname, homeworkname, startTime, endTime);
    }

    /**
    * @Description: 作业提交功能，插入作业
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-21
    */
    @Override
    public int insert(HomeworkWithBLOBs record)
    {
        return homeworkMapper.insert(record);
    }
}
