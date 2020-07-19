package admin.service;

import admin.generator.entity.Commentgood;

import java.util.List;

public interface CommentgoodService
{
    int insertSelective(Commentgood record);

    int updateByPrimaryKeySelective(Commentgood record);

    Commentgood selectByPrimaryKey(Integer id);

    Commentgood presence(Integer uid, Integer cid);

    List<Commentgood> queryAll();


}
