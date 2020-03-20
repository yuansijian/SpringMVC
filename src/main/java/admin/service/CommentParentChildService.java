package admin.service;

import admin.generator.entity.CommentParentChild;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentParentChildService
{
    List<CommentParentChild> queryAll();
    int insert(CommentParentChild record);
    List<CommentParentChild> queryByUsername(String username);


}
