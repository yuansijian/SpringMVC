package admin.service.impl;

import admin.generator.dao.CommentParentChildMapper;
import admin.generator.entity.CommentParentChild;
import admin.service.CommentParentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 留言回复
 * @author: Defend
 * @create: 2020-03-15 21:05
 **/
@Service
public class CommentParentChildImpl implements CommentParentChildService
{
    @Autowired
    CommentParentChildMapper commentParentChildMapper;

    /**
    * @Description: 查找所有
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-15
    */
    @Override
    public List<admin.generator.entity.CommentParentChild> queryAll()
    {
        return commentParentChildMapper.queryAll();
    }

    /**
    * @Description: 插入回复
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-16
    */
    @Override
    public int insert(CommentParentChild record)
    {
        return commentParentChildMapper.insert(record);
    }

    /**
    * @Description: 按用户名查找，查看自身回复消息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-20
    */
    @Override
    public List<CommentParentChild> queryByUsername(String username)
    {
        return commentParentChildMapper.queryByUsername(username);
    }
}
