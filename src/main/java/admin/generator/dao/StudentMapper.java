package admin.generator.dao;

import admin.generator.entity.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> queryAll();

    long selectByCountPrimaryKey();

    List<Student> fuzzySearch(String conditions);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);
}