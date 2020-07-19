package admin.service;

import admin.generator.entity.Pictureteacher;

import java.util.List;

public interface PictureteacherService
{
    List<Pictureteacher> queryAll();

    List<Pictureteacher> fuzzySearch(String startTime, String endTime, String pname);

    int insert(Pictureteacher record);

    int updateByPrimaryKeySelective(Pictureteacher record);

    Pictureteacher selectByPrimaryKey(Integer id);


}
