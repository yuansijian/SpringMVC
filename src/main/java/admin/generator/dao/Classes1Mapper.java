package admin.generator.dao;

import admin.generator.entity.Classes1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Classes1Mapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Classes1 record);

    int insertSelective(Classes1 record);

    Classes1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classes1 record);

    int updateByPrimaryKeyWithBLOBs(Classes1 record);

    int updateByPrimaryKey(Classes1 record);

    List<Classes1> queryAll();

    List<String> queryClass();

    List<Classes1> fuzzyQuery(@Param("keyword") String keyword);

    List<Classes1> queryUsed();
}