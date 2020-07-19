package admin.service.impl;

import admin.generator.dao.ReplygoodMapper;
import admin.generator.entity.Replygood;
import admin.service.ReplygoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SpringMVC
 * @description: 回复留言表
 * @author: Defend
 * @create: 2020-06-25 10:33
 **/
@Service
public class ReplygoodServiceImpl implements ReplygoodService
{
    @Autowired
    private ReplygoodMapper replygoodMapper;

    @Override
    public int insert(Replygood record)
    {
        return replygoodMapper.insert(record);
    }

    @Override
    public Replygood selectByPrimaryKey(Integer id)
    {
        return replygoodMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Replygood record)
    {
        return replygoodMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Replygood existId(int uid, int cid)
    {
        return replygoodMapper.existId(uid, cid);
    }

    @Override
    public List<Replygood> queryAll()
    {
        return replygoodMapper.queryAll();
    }
}
