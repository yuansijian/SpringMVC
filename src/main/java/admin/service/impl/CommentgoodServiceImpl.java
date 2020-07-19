package admin.service.impl;

import admin.generator.dao.CommentgoodMapper;
import admin.generator.entity.Commentgood;
import admin.service.CommentgoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 评论点赞
 * @author: Defend
 * @create: 2020-06-19 14:12
 **/
@Service
public class CommentgoodServiceImpl implements CommentgoodService
{
    @Autowired
    private CommentgoodMapper commentgoodMapper;


    @Override
    public int insertSelective(Commentgood record)
    {

        return commentgoodMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Commentgood record)
    {
        return commentgoodMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Commentgood selectByPrimaryKey(Integer id)
    {
        return commentgoodMapper.selectByPrimaryKey(id);
    }

    @Override
    public Commentgood presence(Integer uid, Integer cid)
    {
        return commentgoodMapper.presence(uid, cid);
    }

    @Override
    public List<Commentgood> queryAll()
    {
        return commentgoodMapper.queryAll();
    }
}
