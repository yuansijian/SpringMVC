package admin.controller;

import admin.generator.entity.Administrator;
import admin.generator.entity.Classes1;
import admin.generator.entity.Student;
import admin.generator.entity.Teacher;
import admin.service.AdministratorService;
import admin.service.Classes1Service;
import admin.service.StudentService;
import admin.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static admin.controller.main.getDate;

/**
 * @program: SpringMVC
 * @description: 用户
 * @author: Yuan Sijian
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
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private Classes1Service classes1Service;

    /**
     * @Description: 新学生
     * @Param: null
     * @return: newStudent.ftl
     * @Author: Yuan Sijian
     * @Date: 20-2-14
     */
    @RequestMapping("newStudent")
    public String newStudent(@RequestParam(value = "stuname", defaultValue = "") String stuname, Model model, @RequestParam(value = "stuclass", defaultValue = "") String stuclass, @RequestParam(value = "registeredStartTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01") String endTime, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        //        System.out.println(stuname+stuclass+startTime+endTime + teaname);

        if (stuname.equals("") && stuclass.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01"))
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
        } else
        {

            List<Student> studentList = studentService.queryFuzzyRegistered(stuname, stuclass, "", startTime, endTime);
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
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @RequestMapping("newTeacher")
    public String newTeacher(@RequestParam(value = "teaname", defaultValue = "") String teaname, Model model, @RequestParam(value = "registeredStartTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01") String endTime, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        if (teaname.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01"))
        {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

            String monday = dateFormat.format(Admin.getThisWeekMonday(date));
            String sunday = dateFormat.format(Admin.getThisWeekSunday(date));

            List<Teacher> teacherList = teacherService.checkTea();

            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        } else
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
     * @Description: 教师审核
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-19
     */
    @ResponseBody
    @RequestMapping("checkTea")
    public int checkTea(@RequestParam("id") int id, @RequestParam("isDelete") int isDelete)
    {
        Teacher teacher = new Teacher();

        teacher.setIsDelete(isDelete);
        teacher.setId(id);

        Teacher temp = teacherService.selectByPrimaryKey(id);

        if (isDelete == 0)
        {
            Administrator administrator = new Administrator();

            administrator.setUsername(temp.getUsername());
            administrator.setPassword(temp.getPassword());
            administrator.setAuthority(2);
            administrator.setLoginnumber(temp.getLoginnumber() + 1);
            administrator.setCreatetime(getDate());
            administrator.setImageurl("/statics/headerPicture/1.jpg");
            administrator.setEmail(temp.getTeamail());
            administrator.setIsDelete(0);

            administratorService.insert(administrator);
        }

        return teacherService.updateByPrimaryKeySelective(teacher);
    }


    /**
     * @Description: 学生信息
     * @Param: null
     * @return: studentInformation.ftl
     * @Author: Yuan Sijian
     * @Date: 20-2-14
     */
    @RequestMapping("studentInformation")
    public String studentInformation(@RequestParam(value = "stuname", defaultValue = "") String stuname, Model model, @RequestParam(value = "stuclass", defaultValue = "") String stuclass, @RequestParam(value = "registeredStartTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01") String endTime, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session, @RequestParam(value = "stugrade", defaultValue = "") String stugrade)
    {
        PageHelper.startPage(pageNum, pageSize);

        //        System.out.println(stuname+stuclass+startTime+endTime + teaname);

        if (stuname.equals("") && stuclass.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01") && stugrade.equals(""))
        {
            List<Student> studentList = studentService.queryAll();
            PageInfo<Student> pageInfo1 = new PageInfo(studentList);
            model.addAttribute("studentList", pageInfo1);
        } else
        {

            List<Student> studentList = studentService.queryFuzzyRegistered(stuname, stuclass, stugrade, startTime, endTime);
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
     * @Author: Yuan Sijian
     * @Date: 20-2-29
     */
    @RequestMapping("teacherInformation")
    public String teacherInformation(@RequestParam(value = "teaname", defaultValue = "") String teaname, Model model, @RequestParam(value = "registeredStartTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "registeredEndTime", defaultValue = "1970-01-01") String endTime, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        if (teaname.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01"))
        {
            List<Teacher> teacherList = teacherService.queryAll();

            PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
            model.addAttribute("teacherList", pageInfo2);
        } else
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
     * @Description: 个人信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
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
     * @Description: 修改个人信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-3
     */
    @RequestMapping("updateProfile")
    public String updateProfile(Model model, Administrator administrator, HttpSession session)
    {
        Administrator temp = (Administrator) session.getAttribute("user");
        int id = temp.getId();
        administrator.setId(id);
        if (administratorService.updateByPrimaryKeySelective(administrator) == 1)
        {
            //            session.invalidate();
            administrator = administratorService.selectByPrimaryKey(id);
            session.setAttribute("user", administrator);
        }

        return "profile.ftl";
    }


    /**
     * @Description: 修改密码
     * @Param:
     * @return:
     * @Author: Yuan Sijian
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
     * @Description: 更新密码
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-3
     */
    @RequestMapping("updatePwd")
    public String updatePwd(Model model, HttpSession session, @RequestParam("newpwd") String newpwd, @RequestParam("oldpwd") String oldpwd)
    {

        Administrator administrator = (Administrator) session.getAttribute("user");
        String pwd = administrator.getPassword();
        Administrator temp = new Administrator();

        if (pwd.equals(oldpwd))
        {
            temp.setPassword(newpwd);
            temp.setId(administrator.getId());
            administratorService.updateByPrimaryKeySelective(temp);

            return "redirect:/user/editPwd";
        }


        return "error.html";
    }

    /**
     * @Description: 更改头像
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-3
     */
    @RequestMapping("changePhoto")
    public String changePhoto(@RequestParam("imageURL") MultipartFile multipartFile, @RequestParam("id") int id, HttpSession session)
    {
        Administrator administrator = new Administrator();

        if (!multipartFile.isEmpty())
        {
            try
            {
                String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/headerPicture/";

                //获取原文件名
                String name = multipartFile.getOriginalFilename();
                //获取扩展名
                String type = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
                String newFileName = id + "." + type;

                File dir = new File(rootPath + newFileName);

                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                multipartFile.transferTo(dir);

                Thumbnails.of(dir).size(68, 68).keepAspectRatio(false).toFile(dir);

                administrator.setId(id);
                administrator.setImageurl("/statics/headerPicture/" + newFileName);
                administratorService.updateByPrimaryKeySelective(administrator);

                System.out.println("You successfully uploaded file=" + multipartFile.getOriginalFilename());


            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return "redirect:/user/profile";
    }

    /**
     * @Description: 编辑学生信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @RequestMapping("editStudentInfo/{id}")
    public String editStudentInfo(@PathVariable("id") Integer id, Model model, HttpSession session)
    {
        Student student = studentService.adminUpdateSelect(id);

        Administrator administrator = (Administrator) session.getAttribute("user");

        List<Classes1> list = classes1Service.queryUsed();

        model.addAttribute("gradeList", list);
        model.addAttribute("administrator", administrator);
        model.addAttribute("student", student);


        return "editStudentInfo.ftl";
    }

    /**
     * @Description: 更新学生信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @ResponseBody
    @RequestMapping("updateStudentInfo/{id}")
    public int updateStudentInfo(Student student, @PathVariable("id") int id, Model model, HttpSession session)
    {
        //        System.out.println(student);
        //        System.out.println(id);
        student.setId(id);
        return studentService.updateByPrimaryKeySelective(student);

        //        student = studentService.adminUpdateSelect(id);
        //
        //        Administrator administrator = (Administrator) session.getAttribute("user");
        //        model.addAttribute("administrator", administrator);
        //
        //        model.addAttribute("student", student);
        //
        //        return "editStudentInfo.ftl";
    }

    /**
     * @Description: 删除学生
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @ResponseBody
    @RequestMapping("deleteStudent/{id}")
    public int deleteStudent(@PathVariable("id") Integer id, Model model, HttpSession session)
    {

        //        PageHelper.startPage(1, 10);

        Student student = new Student();
        student.setId(id);
        student.setIsDelete(1);
        return studentService.updateByPrimaryKeySelective(student);

        //        List<Student> studentList = studentService.queryAll();
        //        PageInfo<Student> pageInfo1 = new PageInfo(studentList);
        //
        //        Administrator administrator = (Administrator) session.getAttribute("user");
        //        model.addAttribute("administrator", administrator);
        //        model.addAttribute("studentList", pageInfo1);


        //        return "newStudent.ftl";
    }

    /**
     * @Description: 查找更新教师信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @RequestMapping("editTeacherInfo/{id}")
    public String editTeacherInfo(@PathVariable("id") Integer id, Model model, HttpSession session)
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
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @ResponseBody
    @RequestMapping("updateTeacherInfo/{id}")
    public int updateTeacherInfo(Teacher teacher, @PathVariable("id") Integer id, Model model, HttpSession session)
    {
        teacher.setId(id);

        return teacherService.updateByPrimaryKeySelective(teacher);


        //        teacher = teacherService.adminUpdateEdit(id);
        //
        //        Administrator administrator = (Administrator) session.getAttribute("user");
        //        model.addAttribute("administrator", administrator);
        //
        //        model.addAttribute("teacher", teacher);
        //
        //        return "editTeacherInfo.ftl";
    }

    /**
     * @Description: 删除老师
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-2-28
     */
    @ResponseBody
    @RequestMapping("deleteTeacher/{id}")
    public int deleteTeacher(@PathVariable("id") Integer id, Model model, HttpSession session)
    {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setIsDelete(1);
        return teacherService.updateByPrimaryKeySelective(teacher);

        //        PageHelper.startPage(1, 10);
        //
        //        List<Teacher> teacherList = teacherService.queryAll();
        //        PageInfo<Student> pageInfo2 = new PageInfo(teacherList);
        //
        //        Administrator administrator = (Administrator) session.getAttribute("user");
        //        model.addAttribute("administrator", administrator);
        //        model.addAttribute("teacherList", pageInfo2);
        //
        //        return "newTeacher.ftl";

    }
}
