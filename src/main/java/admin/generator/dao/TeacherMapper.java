package admin.generator.dao;

import admin.generator.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    long selectByCountPrimaryKey();

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKeyWithBLOBs(Teacher record);

    int updateByPrimaryKey(Teacher record);
}