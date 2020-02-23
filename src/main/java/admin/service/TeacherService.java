package admin.service;

import admin.generator.entity.Teacher;

public interface TeacherService
{
    Teacher selectByPrimaryKey(Integer id);
    long selectByCountPrimaryKey();

}
