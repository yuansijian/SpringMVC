package admin.controller;


import admin.generator.entity.Student;
import admin.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: SpringMVC
 * @description: 教师中心
 * @author: Defend
 * @create: 2020-02-10 22:42
 **/
@Controller
@RequestMapping("teacher")
@CrossOrigin
public class TeacherCenter
{
    @Autowired
    private StudentService studentService;
    /**
    * @Description: 管理学生界面
    * @Param: null
    * @return: manageStudent.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping(value = "manageStudent")
    public String manageStudent(@RequestParam(value = "keyword", defaultValue = "[")String conditions, Model model,
                                @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "2")int pageSize)
    {
        long count = studentService.selectByCountPrimaryKey() / pageSize;

        PageHelper.startPage(pageNum, pageSize);

        try
        {
            if (conditions.equals("["))
            {
                List<Student> studentList = studentService.queryAll();
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);
            }
            else
            {
                List<Student> studentList = studentService.fuzzySearch(conditions);
//                model.addAttribute("studentList", studentList);
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        model.addAttribute("count", count);


        return "manageStudent.ftl";
    }

    
    /**
    * @Description: 作业管理主界面
    * @Param: null
    * @return: manageHomework.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("manageHomework")
    public String manageHomework()
    {

        return "manageHomework.ftl";
    }

}
