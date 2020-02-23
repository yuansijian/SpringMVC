package admin.service;

import admin.generator.entity.Student;

import java.util.List;

public interface StudentService
{
    long selectByCountPrimaryKey();
    List<Student> queryAll();
    List<Student> fuzzySearch(String conditions);

}
