package admin.service.impl;

import admin.generator.dao.PictureteacherMapper;
import admin.generator.entity.Pictureteacher;
import admin.service.PictureteacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 图文教学
 * @author: Yuan Sijian
 * @create: 2020-03-06 13:48
 **/
@Service
public class PictureteacherServiceImpl implements PictureteacherService
{
    @Autowired
    PictureteacherMapper pictureteacherMapper;
    /**
    * @Description: 查询所有图文教学
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-6
    */
    @Override
    public List<Pictureteacher> queryAll()
    {
        return pictureteacherMapper.queryAll();
    }

    /**
    * @Description: 搜索
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-6
    */
    @Override
    public List<Pictureteacher> fuzzySearch(String startTime, String endTime, String pname)
    {
        return pictureteacherMapper.fuzzySearch(startTime, endTime, pname);
    }

    /**
    * @Description:新增
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-6
    */
    @Override
    public int insert(Pictureteacher record)
    {
        return pictureteacherMapper.insert(record);
    }

    /**
    * @Description: 更新（假删除)
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-7
    */
    @Override
    public int updateByPrimaryKeySelective(Pictureteacher record)
    {
        return pictureteacherMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 查询
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-7
    */
    @Override
    public Pictureteacher selectByPrimaryKey(Integer id)
    {
        return pictureteacherMapper.selectByPrimaryKey(id);
    }
}
