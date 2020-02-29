package admin.service;

import admin.generator.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentService
{
    long selectByCountPrimaryKey();
    List<Student> queryAll();
    List<Student> fuzzySearch(String conditions);
    List<HashMap> registeredQuery(String startTime, String endTime);
    List<Student> queryByClass(String stuclass);
    List<Student> queryByName(String stuname);
    List<Student> queryByNameAndClass(String stuname, String stuclass);
    List<Student> queryFuzzyRegistered(String stuname, String stuclass, String startTime, String endTime);
    Student selectByPrimaryKey(Integer id);
    Student adminUpdateSelect(Integer id);
    int updateByPrimaryKeySelective(Student record);
    int deleteByPrimaryKey(Integer id);
    List<Student> queryRes(@Param("startTime")String startTime, @Param("endTime")String endTime);

}
