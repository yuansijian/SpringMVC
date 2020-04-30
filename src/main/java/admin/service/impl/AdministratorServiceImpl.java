package admin.service.impl;

import admin.generator.dao.AdministratorMapper;
import admin.generator.entity.Administrator;
import admin.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 管理员
 * @author: Yuan Sijian
 * @create: 2020-02-29 21:32
 **/
@Service
public class AdministratorServiceImpl implements AdministratorService
{
    @Autowired
    AdministratorMapper administratorMapper;
    /**
    * @Description: 查找用户用于登录
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-29
    */
    @Override
    public Administrator queryByUsernameAndPassword(String username, String password)
    {
        return administratorMapper.queryByUsernameAndPassword(username, password);
    }

    /**
    * @Description: 更新管理员信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-3
    */
    @Override
    public int updateByPrimaryKeySelective(Administrator record)
    {
        return administratorMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 根据主键查找信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-3
    */
    @Override
    public Administrator selectByPrimaryKey(Integer id)
    {
        return administratorMapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 插入老师管理员
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-23
    */
    @Override
    public int insert(Administrator record)
    {
        return administratorMapper.insert(record);
    }
}
