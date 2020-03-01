package admin.controller;

import admin.generator.entity.Administrator;
import admin.generator.entity.Student;
import admin.generator.entity.Teacher;
import admin.service.StudentService;
import admin.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: SpringMVC
 * @description: 用户
 * @author: Defend
 * @create: 2020-02-10 22:44
 **/
@Controller
@RequestMapping("user")
@CrossOrigin
public class User
{
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /**
    * @Description: 新学生
    * @Param: null
    * @return: newStudent.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("newStudent")
    public String newuser(@RequestParam(value = "stuname", defaultValue = "")String stuname , Model model,
                          @RequestParam(value = "stuclass", defaultValue = "")String stuclass,
                          @RequestParam(value = "registeredStartTime",defaultValue = "1970-01-01")String startTime,
                          @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01")String endTime,
                          @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "2")int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

//        System.out.println(stuname+stuclass+startTime+endTime + teaname);

        if(stuname.equals("")&&stuclass.equals("")&&startTime.equals("1970-01-01")&&endTime.equals("1970-01-01"))
        {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

            String monday = dateFormat.format(Admin.getThisWeekMonday(date));
            String sunday = dateFormat.format(Admin.getThisWeekSunday(date));

//            System.out.println(monday+sunday);

            List<Student> studentList = studentService.queryRes(monday, sunday);

//            System.out.println(studentList);

            PageInfo<Student> pageInfo1 = new PageInfo(studentList);
            model.addAttribute("studentList", pageInfo1);
        }
        else
        {

            List<Student> studentList = studentService.queryFuzzyRegistered(stuname, stuclass, startTime, endTime);
            PageInfo<Student> pageInfo1 = new PageInfo(studentList);
            model.addAttribute("studentList", pageInfo1);
        }


        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "newStudent.ftl";
    }

    /**
    * @Description: 新教师
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("newTeacher")
    public String newTeacher(@RequestParam(value = "teaname", defaultValue = "")String teaname, Model model,
                             @RequestParam(value = "registeredStartTime",defaultValue = "1970-01-01")String startTime,
                             @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01")String endTime,
                             @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "2")int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        if(teaname.equals("")&&startTime.equals("1970-01-01")&&endTime.equals("1970-01-01"))
        {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

            String monday = dateFormat.format(Admin.getThisWeekMonday(date));
            String sunday = dateFormat.format(Admin.getThisWeekSunday(date));

            List<Teacher> teacherList = teacherService.queryRes(monday, sunday);

            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        }
        else
        {
            List<Teacher> teacherList = teacherService.queryFuzzyRegistered(teaname, startTime, endTime);
            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "newTeacher.ftl";
    }

    /**
    * @Description: 活跃度
    * @Param: null
    * @return: activity.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("activity")
    public String activity()
    {
        return "activity.ftl";
    }

    /**
    * @Description: 学生信息
    * @Param: null
    * @return: studentInformation.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("studentInformation")
    public String studentInformation(@RequestParam(value = "stuname", defaultValue = "")String stuname ,Model model,
                                     @RequestParam(value = "stuclass", defaultValue = "")String stuclass,
                                     @RequestParam(value = "registeredStartTime",defaultValue = "1970-01-01")String startTime,
                                     @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01")String endTime,
                                     @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "2")int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        //        System.out.println(stuname+stuclass+startTime+endTime + teaname);

        if(stuname.equals("")&&stuclass.equals("")&&startTime.equals("1970-01-01")&&endTime.equals("1970-01-01"))
        {
            List<Student> studentList = studentService.queryAll();
            PageInfo<Student> pageInfo1 = new PageInfo(studentList);
            model.addAttribute("studentList", pageInfo1);
        }
        else
        {

            List<Student> studentList = studentService.queryFuzzyRegistered(stuname, stuclass, startTime, endTime);
            PageInfo<Student> pageInfo1 = new PageInfo(studentList);
            model.addAttribute("studentList", pageInfo1);
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "studentInformation.ftl";
    }

    /**
    * @Description: 教师信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-29
    */
    @RequestMapping("teacherInformation")
    public String teacherInformation(@RequestParam(value = "teaname", defaultValue = "")String teaname, Model model,
                                     @RequestParam(value = "registeredStartTime",defaultValue = "1970-01-01")String startTime,
                                     @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01")String endTime,
                                     @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "2")int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        if(teaname.equals("")&&startTime.equals("1970-01-01")&&endTime.equals("1970-01-01"))
        {
            List<Teacher> teacherList = teacherService.queryAll();

            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        }
        else
        {
            List<Teacher> teacherList = teacherService.queryFuzzyRegistered(teaname, startTime, endTime);
            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "teacherInformation.ftl";
    }

    /**
    * @Description: 学生学习进度
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("schedule")
    public String schedule()
    {
        return "schedule.ftl";
    }

    /**
    * @Description: 个人信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-26
    */
    @RequestMapping("profile")
    public String profile(Model model, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "profile.ftl";
    }

    /**
    * @Description: 修改密码
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-26
    */
    @RequestMapping("editPwd")
    public String editPwd(Model model, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "editPwd.ftl";
    }
    
    /**
    * @Description: 编辑学生信息
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("editStudentInfo/{id}")
    public String editStudentInfo(@PathVariable("id")Integer id, Model model, HttpSession session)
    {
        Student student = studentService.adminUpdateSelect(id);

        Administrator administrator = (Administrator) session.getAttribute("user");

        model.addAttribute("administrator", administrator);
        model.addAttribute("student", student);



        return "editStudentInfo.ftl";
    }
    /**
    * @Description: 更新学生信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("updateStudentInfo/{id}")
    public String updateStudentInfo(Student student, @PathVariable("id")int id, Model model, HttpSession session)
    {
//        System.out.println(student);
//        System.out.println(id);
        student.setId(id);
        System.out.println(studentService.updateByPrimaryKeySelective(student));

        student = studentService.adminUpdateSelect(id);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        model.addAttribute("student", student);

        return "editStudentInfo.ftl";
    }

    /**
    * @Description: 删除学生
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id")Integer id, Model model, HttpSession session)
    {

        PageHelper.startPage(1, 1);

        Student student = new Student();
        student.setId(id);
        student.setIsDelete(1);
        studentService.updateByPrimaryKeySelective(student);

        List<Student> studentList = studentService.queryAll();
        PageInfo<Student> pageInfo1 = new PageInfo(studentList);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
        model.addAttribute("studentList", pageInfo1);


        return "newStudent.ftl";
    }

    /**
    * @Description: 查找更新教师信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("editTeacherInfo/{id}")
    public String editTeacherInfo(@PathVariable("id")Integer id, Model model, HttpSession session)
    {

        Teacher teacher = teacherService.adminUpdateEdit(id);
        model.addAttribute("teacher", teacher);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "editTeacherInfo.ftl";
    }

    /**
    * @Description: 更新老师信息
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("updateTeacherInfo/{id}")
    public String updateTeacherInfo(Teacher teacher, @PathVariable("id")Integer id, Model model, HttpSession session)
    {
        teacher.setId(id);
        teacherService.updateByPrimaryKeySelective(teacher);

        teacher = teacherService.adminUpdateEdit(id);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        model.addAttribute("teacher", teacher);

        return "editTeacherInfo.ftl";
    }

    /**
    * @Description: 删除老师
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-28
    */
    @RequestMapping("deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id")Integer id, Model model, HttpSession session)
    {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setIsDelete(1);
        teacherService.updateByPrimaryKeySelective(teacher);

        PageHelper.startPage(1, 1);

        List<Teacher> teacherList = teacherService.queryAll();
        PageInfo<Student> pageInfo2 = new PageInfo(teacherList);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
        model.addAttribute("teacherList", pageInfo2);

        return "newTeacher.ftl";

    }
}
