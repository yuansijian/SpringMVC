package admin.service.impl;

import admin.generator.dao.TeacherMapper;
import admin.generator.entity.Teacher;
import admin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 教师service层
 * @author: Defend
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
    * @Author: Defend
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
    * @Author: Defend
    * @Date: 20-2-21
    */
    @Override
    public long selectByCountPrimaryKey()
    {
        return teacherMapper.selectByCountPrimaryKey();
    }

}
