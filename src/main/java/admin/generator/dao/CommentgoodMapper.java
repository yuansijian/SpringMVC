package admin.generator.dao;

import admin.generator.entity.Commentgood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentgoodMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Commentgood record);

    int insertSelective(Commentgood record);

    Commentgood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commentgood record);

    int updateByPrimaryKey(Commentgood record);

    Commentgood presence(@Param("uid") Integer uid, @Param("cid") Integer cid);

    List<Commentgood> queryAll();
}