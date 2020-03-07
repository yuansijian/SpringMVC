package admin.generator.dao;

import admin.generator.entity.Pictureteacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pictureteacher record);

    int insertSelective(Pictureteacher record);

    Pictureteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pictureteacher record);

    int updateByPrimaryKey(Pictureteacher record);

    List<Pictureteacher> queryAll();
    List<Pictureteacher> fuzzySearch(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("pname")String pname);
}