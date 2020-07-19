package admin.generator.dao;

import admin.generator.entity.Replygood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplygoodMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Replygood record);

    int insertSelective(Replygood record);

    Replygood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Replygood record);

    int updateByPrimaryKey(Replygood record);

    Replygood existId(@Param("uid") int uid, @Param("cid") int cid);

    List<Replygood> queryAll();
}