package admin.generator.dao;

import admin.generator.entity.Comment;
import admin.generator.entity.CommentWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(CommentWithBLOBs record);

    int insertSelective(CommentWithBLOBs record);

    CommentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentWithBLOBs record);

    int updateByPrimaryKey(Comment record);

    List<CommentWithBLOBs> queryAll();

    int addMessage(@Param("startTime") String startTime, @Param("endTime") String endTime);

}