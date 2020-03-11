package admin.service;

import admin.generator.entity.HomeworkWithBLOBs;

import java.util.List;

public interface HomeworkService
{
    List<HomeworkWithBLOBs> queryAll();
    List<HomeworkWithBLOBs> fuzzyQuery(String stuname, String homeworkname, String startTime, String endTime);
}
