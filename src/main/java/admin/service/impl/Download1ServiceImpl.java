package admin.service.impl;

import admin.generator.dao.Download1Mapper;
import admin.generator.entity.Download1;
import admin.service.Download1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringMVC
 * @description: 统计下载总数
 * @author: Yuan Sijian
 * @create: 2020-03-30 15:44
 **/
@Service
public class Download1ServiceImpl implements Download1Service
{
    @Autowired
    Download1Mapper download1Mapper;

    /**
     * @Description: 查找
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-30
     */
    @Override
    public Download1 selectByPrimaryKey(Integer id)
    {
        return download1Mapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 更新
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-30
     */
    @Override
    public int updateByPrimaryKeySelective(Download1 record)
    {

        return download1Mapper.updateByPrimaryKeySelective(record);
    }
}
