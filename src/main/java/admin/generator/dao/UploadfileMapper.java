package admin.generator.dao;

import admin.generator.entity.Uploadfile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UploadfileMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Uploadfile record);

    int insertSelective(Uploadfile record);

    Uploadfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uploadfile record);

    int updateByPrimaryKey(Uploadfile record);

    List<Uploadfile> queryAll();

    List<Uploadfile> fuzzyQuery(@Param("fileName") String fileName, @Param("startTime") String startTime, @Param("endTime") String endTime);
}