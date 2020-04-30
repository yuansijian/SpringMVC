package admin.service.impl;

import admin.generator.dao.UploadfileMapper;
import admin.generator.entity.Uploadfile;
import admin.service.UploadconfigService;
import admin.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 上传文件
 * @author: Yuan Sijian
 * @create: 2020-03-01 20:58
 **/
@Service
public class UploadfileServiceImpl implements UploadfileService
{
    @Autowired
    UploadfileMapper uploadfileMapper;
    /**
    * @Description: 插入上传文件信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-1
    */
    @Override
    public int insert(Uploadfile record)
    {
        return uploadfileMapper.insert(record);
    }

    /**
    * @Description: 查询已上传文件信息
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-5
    */
    @Override
    public List<Uploadfile> queryAll()
    {
        return uploadfileMapper.queryAll();
    }

    /**
    * @Description: 模糊查询功能
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-5
    */
    @Override
    public List<Uploadfile> fuzzyQuery(String fileName, String startTime, String endTime)
    {
        return uploadfileMapper.fuzzyQuery(fileName, startTime, endTime);
    }

    /**
    * @Description: 删除文件
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-5
    */
    @Override
    public int deleteByPrimaryKey(Integer id)
    {
        return uploadfileMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Description: 更新上传文件信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-5
    */
    @Override
    public int updateByPrimaryKeySelective(Uploadfile record)
    {
        return uploadfileMapper.updateByPrimaryKeySelective(record);
    }
}
