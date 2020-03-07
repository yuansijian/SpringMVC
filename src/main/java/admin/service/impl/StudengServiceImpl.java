package admin.service.impl;

import admin.generator.dao.StudentMapper;
import admin.generator.entity.Student;
import admin.service.StudentService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    StudentMapper studentMapper;

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

    /**
    * @Description: 模糊查找
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-26
    */
    @Override
    public List<Student> fuzzySearch(String conditions)
    {
        return studentMapper.fuzzySearch(conditions);
    }

    /**
    * @Description: 时间范围注册数
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-26
    */
    @Override
    public List<Integer> registeredQuery(String startTime, String endTime)
    {
        return studentMapper.registeredQuery(startTime, endTime);
    }


    /**
    * @Description: 按班级查找学生
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-27
    */
    @Override
    public List<Student> queryByClass(String stuclass)
    {
        return studentMapper.queryByClass(stuclass);
    }

    /**
    * @Description: 按姓名模糊查找
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-27
    */
    @Override
    public List<Student> queryByName(String stuname)
    {
        return studentMapper.queryByName(stuname);
    }

    /**
    * @Description: 按姓名班级查找
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-27
    */
    @Override
    public List<Student> queryByNameAndClass(String stuname, String stuclass)
    {
        return studentMapper.queryByNameAndClass(stuname, stuclass);
    }

    /**
    * @Description: 注册用户管理查找
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-27
    */
    @Override
    public List<Student> queryFuzzyRegistered(String stuname, @Param("stuclass") String stuclass, String startTime, String endTime)
    {
        return studentMapper.queryFuzzyRegistered(stuname, stuclass, startTime, endTime);
    }

    /**
    * @Description: 按主键查找学生
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @Override
    public Student selectByPrimaryKey(Integer id)
    {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 查找更新
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @Override
    public Student adminUpdateSelect(Integer id)
    {
        return studentMapper.adminUpdateSelect(id);
    }

    /**
    * @Description: 更新数据
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @Override
    public int updateByPrimaryKeySelective(Student record)
    {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 删除学生
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @Override
    public int deleteByPrimaryKey(Integer id)
    {
        return deleteByPrimaryKey(id);
    }

    /**
    * @Description: newuser学生信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-29
    */
    @Override
    public List<Student> queryRes(String startTime, String endTime)
    {
        return studentMapper.queryRes(startTime, endTime);
    }

    /**
    * @Description: 活跃度功能
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-4
    */
    @Override
    public int queryCountLogin(String startTime, String endTime)
    {
        return studentMapper.queryCountLogin(startTime, endTime);
    }
}
