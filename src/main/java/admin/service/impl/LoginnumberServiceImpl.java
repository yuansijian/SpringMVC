package admin.service.impl;

import admin.generator.dao.LoginnumberMapper;
import admin.generator.entity.Loginnumber;
import admin.service.LoginnumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 活跃度
 * @author: Defend
 * @create: 2020-05-25 16:35
 **/
@Service
public class LoginnumberServiceImpl implements LoginnumberService
{
    @Autowired
    LoginnumberMapper loginnumberMapper;

    /**
    * @Description: 活跃度查询
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-5-25
    */
    @Override
    public Loginnumber selectByPrimaryKey(Integer id)
    {
        return loginnumberMapper.selectByPrimaryKey(id);

    }

    /**
    * @Description: 活跃度更新
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-5-26
    */
    @Override
    public int updateByPrimaryKeySelective(Loginnumber record)
    {
        return loginnumberMapper.updateByPrimaryKeySelective(record);
    }
}
