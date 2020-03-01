package admin.service.impl;

import admin.generator.dao.AdministratorMapper;
import admin.generator.entity.Administrator;
import admin.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 管理员
 * @author: Defend
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
    * @Author: Defend
    * @Date: 20-2-29
    */
    @Override
    public Administrator queryByUsernameAndPassword(String username, String password)
    {
        return administratorMapper.queryByUsernameAndPassword(username, password);
    }
}
