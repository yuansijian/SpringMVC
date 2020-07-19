package admin.service;

import admin.generator.entity.Classes1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Classes1Service
{
    List<Classes1> queryAll();

    List<String> queryClass();

    List<Classes1> fuzzyQuery(String keyword);

    int insert(Classes1 record);

    int updateByPrimaryKeySelective(Classes1 record);

    Classes1 selectByPrimaryKey(Integer id);

    List<Classes1> queryUsed();


}
