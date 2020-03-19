package admin.service;

import admin.generator.entity.Student;

import java.util.List;

public interface StudentService
{
    long selectByCountPrimaryKey();
    List<Student> queryAll();
    List<Student> fuzzySearch(String conditions);
    List<Integer> registeredQuery(String startTime, String endTime);
    List<Student> queryByGrade(String stugrade);
    List<Student> queryByName(String stuname);
    List<Student> queryByNameAndGrade(String stuname, String stugrade);
    List<Student> queryFuzzyRegistered(String stuname, String stuclass, String stugrade, String startTime, String endTime);
    Student selectByPrimaryKey(Integer id);
    Student adminUpdateSelect(Integer id);
    int updateByPrimaryKeySelective(Student record);
    int deleteByPrimaryKey(Integer id);
    List<Student> queryRes(String startTime, String endTime);
    int queryCountLogin(String startTime, String endTime);
    List<Integer> queryGrade();
    Student queryUsernameAndPassword(String username, String password);
    int insert(Student record);



}
