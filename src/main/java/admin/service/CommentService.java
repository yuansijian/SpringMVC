package admin.service;

import admin.generator.entity.CommentWithBLOBs;

import java.util.List;

public interface CommentService
{
    List<CommentWithBLOBs> queryAll();

    int insert(CommentWithBLOBs record);

}
