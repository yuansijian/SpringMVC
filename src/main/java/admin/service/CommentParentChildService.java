package admin.service;

import admin.generator.entity.CommentParentChild;

import java.util.List;

public interface CommentParentChildService
{
    List<CommentParentChild> queryAll();
    int insert(CommentParentChild record);

}
