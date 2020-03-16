package admin.generator.dao;

import admin.generator.entity.CommentParentChild;

import java.util.List;

public interface CommentParentChildMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentParentChild record);

    int insertSelective(CommentParentChild record);

    CommentParentChild selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentParentChild record);

    int updateByPrimaryKeyWithBLOBs(CommentParentChild record);

    int updateByPrimaryKey(CommentParentChild record);

    List<CommentParentChild> queryAll();
}