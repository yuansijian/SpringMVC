package admin.service.impl;

import admin.generator.dao.StudentMapper;
import admin.generator.entity.Student;
import admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 学生类
 * @author: Defend
 * @create: 2020-02-21 22:43
 **/
@Service
public class StudengServiceImpl implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;

    /**
    * @Description: 学生用户总数
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-21
    */
    @Override
    public long selectByCountPrimaryKey()
    {
        return studentMapper.selectByCountPrimaryKey();
    }

    /**
    * @Description: 查询全部学生基本信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-22
    */
    @Override
    public List<Student> queryAll()
    {
        return studentMapper.queryAll();
    }

    @Override
    public List<Student> fuzzySearch(String conditions)
    {
        return studentMapper.fuzzySearch(conditions);
    }
}
