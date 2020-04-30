package admin.service.impl;

import admin.generator.dao.VideoMapper;
import admin.generator.entity.Video;
import admin.generator.entity.VideoWithBLOBs;
import admin.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 视频教学
 * @author: Yuan Sijian
 * @create: 2020-03-08 15:26
 **/
@Service
public class VideoServiceImpl implements VideoService
{
    @Autowired
    VideoMapper videoMapper;
    /**
    * @Description: 查询全部文件
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-8
    */
    @Override
    public List<VideoWithBLOBs> queryAll()
    {
        return videoMapper.queryAll();
    }

    /**
    * @Description: 搜索功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-8
    */
    @Override
    public List<VideoWithBLOBs> fuzzyQuery(String startTime, String endTime, String vname)
    {
        return videoMapper.fuzzyQuery(startTime, endTime, vname);
    }

    /**
    * @Description: 插入
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-8
    */
    @Override
    public int insert(VideoWithBLOBs record)
    {
        return videoMapper.insert(record);
    }

    /**
    * @Description: 单个查询
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-8
    */
    @Override
    public VideoWithBLOBs selectByPrimaryKey(Integer id)
    {
        return videoMapper.selectByPrimaryKey(id);
    }

    /**
    * @Description: 删除，（假删除)
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-8
    */
    @Override
    public int updateByPrimaryKeySelective(VideoWithBLOBs record)
    {
        return videoMapper.updateByPrimaryKeySelective(record);
    }
}
