package admin.service.impl;

import admin.generator.dao.UserMapper;
import admin.generator.entity.User;
import admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @program: SpringMVC
 * @description:
 * @author: Yuan Sijian
 * @create: 2020-02-19 14:38
 **/
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int id)
    {
        return userMapper.selectByPrimaryKey(id);
    }


}
