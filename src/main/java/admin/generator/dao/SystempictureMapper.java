package admin.generator.dao;

import admin.generator.entity.Systempicture;

public interface SystempictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Systempicture record);

    int insertSelective(Systempicture record);

    Systempicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Systempicture record);

    int updateByPrimaryKey(Systempicture record);


}