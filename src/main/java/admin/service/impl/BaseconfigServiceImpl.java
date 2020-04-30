package admin.service.impl;

import admin.generator.dao.BaseconfigMapper;
import admin.generator.entity.BaseconfigWithBLOBs;
import admin.service.BaseconfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 网站基本信息
 * @author: Yuan Sijian
 * @create: 2020-03-10 15:49
 **/
@Service
public class BaseconfigServiceImpl implements BaseconfigService
{
    @Autowired
    BaseconfigMapper baseconfigMapper;

    @Override
    public BaseconfigWithBLOBs selectByPrimaryKey(Integer id)
    {
        return baseconfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseconfigWithBLOBs record)
    {
        return baseconfigMapper.updateByPrimaryKeySelective(record);
    }
}
