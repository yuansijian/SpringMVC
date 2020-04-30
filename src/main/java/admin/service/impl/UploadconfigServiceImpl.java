package admin.service.impl;

import admin.generator.dao.UploadconfigMapper;
import admin.generator.entity.Uploadconfig;
import admin.service.UploadconfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 网站文件上传配置
 * @author: Yuan Sijian
 * @create: 2020-02-29 17:14
 **/
@Service
public class UploadconfigServiceImpl implements UploadconfigService
{
     @Autowired
     UploadconfigMapper uploadconfigMapper;
    /**
    * @Description: 查找
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-29
    */
    @Override
    public Uploadconfig selectByPrimaryKey(Integer id)
    {
        return uploadconfigMapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 更新
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-2-29
    */
    @Override
    public int updateByPrimaryKeySelective(Uploadconfig record)
    {
        return uploadconfigMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Description: 更新
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-2-29
    */
    @Override
    public int updateByPrimaryKey(Uploadconfig record)
    {
        return uploadconfigMapper.updateByPrimaryKey(record);
    }
}
