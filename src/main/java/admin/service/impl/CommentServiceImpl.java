package admin.service.impl;

import admin.generator.dao.CommentMapper;
import admin.generator.entity.CommentWithBLOBs;
import admin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 留言功能
 * @author: Defend
 * @create: 2020-03-15 21:13
 **/
@Service
public class CommentServiceImpl implements CommentService
{
    @Autowired
    CommentMapper commentMapper;

    /**
    * @Description: 查找所有
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-15
    */
    @Override
    public List<CommentWithBLOBs> queryAll()
    {
        return commentMapper.queryAll();
    }

    /**
    * @Description: 插入
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-15
    */
    @Override
    public int insert(CommentWithBLOBs record)
    {
        return commentMapper.insert(record);
    }

    /**
    * @Description: 更新，家删除功能
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-23
    */
    @Override
    public int updateByPrimaryKeySelective(CommentWithBLOBs record)
    {
        return commentMapper.updateByPrimaryKeySelective(record);
    }
}
