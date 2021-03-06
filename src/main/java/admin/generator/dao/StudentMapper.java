package admin.generator.dao;

import admin.generator.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> queryByGrade(@Param("stugrade") String stugrade);

    List<Student> queryByName(@Param("stuname") String stuname);

    List<Student> queryByNameAndGrade(@Param("stuname") String stuname, @Param("stugrade") String stugrade);

    Student selectByPrimaryKey(Integer id);

    List<Student> queryAll();

    long selectByCountPrimaryKey();

    List<Student> fuzzySearch(String conditions);

    List<Integer> registeredQuery(@Param("startTime") String startTime, @Param("endTime") String endTime);

    int queryCountLogin(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Student> queryFuzzyRegistered(@Param("stuname") String stuname, @Param("stuclass") String stuclass, @Param("stugrade") String stugrade, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);

    Student adminUpdateSelect(Integer id);

    List<Student> queryRes(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Integer> queryGrade();

    Student queryUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<HashMap> checkHomework(@Param("grade") String grade);
}