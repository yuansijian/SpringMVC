package admin.service.impl;

import admin.generator.dao.SystempictureMapper;
import admin.generator.entity.Systempicture;
import admin.service.SystempictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 系统图片
 * @author: Defend
 * @create: 2020-02-25 22:45
 **/
@Service
public class SystempictureServiceImpl implements SystempictureService
{
    @Autowired
    SystempictureMapper systempictureMapper;

    @Override
    public Systempicture selectByPrimaryKey(Integer id)
    {
        return systempictureMapper.selectByPrimaryKey(id);
    }
}
