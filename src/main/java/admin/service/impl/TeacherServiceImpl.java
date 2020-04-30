package admin.service.impl;

import admin.generator.dao.TeacherMapper;
import admin.generator.entity.Teacher;
import admin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: SpringMVC
 * @description: 教师service层
 * @author: Yuan Sijian
 * @create: 2020-02-21 14:05
 **/
@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    TeacherMapper teacherMapper;

    /**
    * @Description: 教师表查询
    * @Param: id
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-21
    */
    @Override
    public Teacher selectByPrimaryKey(Integer id)
    {
        return teacherMapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 教师表总数统计
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-2-21
    */
    @Override
    public long selectByCountPrimaryKey()
    {
        return teacherMapper.selectByCountPrimaryKey();
    }

    /**
    * @Description: 查找所有老师信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-25
    */
    @Override
    public List<Teacher> queryAll()
    {
        return teacherMapper.queryAll();
    }

    /**
    * @Description: 注册界面模糊查找老师信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-27
    */
    @Override
    public List<Teacher> queryFuzzyRegistered(String teaname, String startTime, String endTime)
    {
        return teacherMapper.queryFuzzyRegistered(teaname, startTime, endTime);
    }

    /**
    * @Description: 查找老师信息用于更新
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-28
    */
    @Override
    public Teacher adminUpdateEdit(Integer id)
    {
        return teacherMapper.adminUpdateEdit(id);
    }

    /**
    * @Description: 更新老师信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-28
    */
    @Override
    public int updateByPrimaryKeySelective(Teacher record)
    {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 删除数据（真删除
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-28
    */
    @Override
    public int deleteByPrimaryKey(Integer id)
    {
        return deleteByPrimaryKey(id);
    }

    /**
    * @Description: 查找最近注册的教师信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-29
    */
    @Override
    public List<Teacher> queryRes(String startTime, String endTime)
    {
        return teacherMapper.queryRes(startTime, endTime);
    }

    /**
    * @Description: 活跃度功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-4
    */
    @Override
    public int queryCountLogin(String startTime, String endTime)
    {
        return teacherMapper.queryCountLogin(startTime, endTime);
    }

    /**
    * @Description: 插入
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-17
    */
    @Override
    public int insert(Teacher record)
    {
        return teacherMapper.insert(record);
    }

    /**
    * @Description: 审核教师
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @Override
    public List<Teacher> checkTea()
    {
        return teacherMapper.checkTea();
    }

    /**
    * @Description: 登录
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-23
    */
    @Override
    public Teacher queryUsernameAndPassword(String username, String password)
    {
        return teacherMapper.queryUsernameAndPassword(username, password);
    }
}
