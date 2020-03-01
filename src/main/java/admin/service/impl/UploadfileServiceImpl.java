package admin.service.impl;

import admin.generator.dao.UploadfileMapper;
import admin.generator.entity.Uploadfile;
import admin.service.UploadconfigService;
import admin.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 上传文件
 * @author: Defend
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
    * @Author: Defend
    * @Date: 20-3-1
    */
    @Override
    public int insert(Uploadfile record)
    {
        return uploadfileMapper.insert(record);
    }
}
