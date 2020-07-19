package admin.service;

import admin.generator.entity.CommentWithBLOBs;

import java.util.List;

public interface CommentService
{
    List<CommentWithBLOBs> queryAll();

    int insert(CommentWithBLOBs record);

    int updateByPrimaryKeySelective(CommentWithBLOBs record);

    int addMessage(String startTime, String endTime);


}
