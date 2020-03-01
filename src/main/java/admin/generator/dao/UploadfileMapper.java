package admin.generator.dao;

import admin.generator.entity.Uploadfile;

public interface UploadfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uploadfile record);

    int insertSelective(Uploadfile record);

    Uploadfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uploadfile record);

    int updateByPrimaryKey(Uploadfile record);
}