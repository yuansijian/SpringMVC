package admin.controller;


import admin.generator.entity.*;
import admin.service.Classes1Service;
import admin.service.GivehomeworkService;
import admin.service.HomeworkService;
import admin.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @program: SpringMVC
 * @description: 教师中心
 * @author: Yuan Sijian
 * @create: 2020-02-10 22:42
 **/
@Controller
@RequestMapping("teacher")
@CrossOrigin
public class TeacherCenter
{
    @Autowired
    private StudentService studentService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private GivehomeworkService givehomeworkService;
    @Autowired
    private Classes1Service classes1Service;

    /**
     * @Description: 管理学生界面
     * @Param: null
     * @return: manageStudent.ftl
     * @Author: Yuan Sijian
     * @Date: 20-2-14
     */
    @RequestMapping(value = "manageStudent")
    public String manageStudent(@RequestParam(value = "stuname", defaultValue = "") String stuname, Model model, @RequestParam(value = "stugrade", defaultValue = "") String stugrade, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session)
    {
        PageHelper.startPage(pageNum, pageSize);

        //统计班级
        List<Integer> class1 = studentService.queryGrade();

        stugrade = stugrade.replace(",", "");

        //获取session的值
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        System.out.println(stuname);

        try
        {
            if ((stuname.equals("") && stugrade.equals("")) || ((stuname.equals("") && stugrade.equals("0"))))
            {
                //                System.out.println(1);

                List<Student> studentList = studentService.queryAll();
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);
            } else if (stuname.equals("") && !stugrade.equals("0"))
            {
                //                System.out.println(2);

                List<Student> studentList = studentService.queryByGrade(stugrade);
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);
            } else if (!stuname.equals("") && stugrade.equals("0"))
            {
                //                System.out.println(3);

                List<Student> studentList = studentService.queryByName(stuname);
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);
            } else
            {
                //                System.out.println(4);

                List<Student> studentList = studentService.queryByNameAndGrade(stuname, stugrade);
                PageInfo<Student> pageInfo = new PageInfo(studentList);
                model.addAttribute("pageInfo", pageInfo);

                //                List<Student> studentList = studentService.fuzzySearch(conditions);
                ////                model.addAttribute("studentList", studentList);
                //                PageInfo<Student> pageInfo = new PageInfo(studentList);
                //                model.addAttribute("pageInfo", pageInfo);
            }
        } catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        model.addAttribute("class", class1);

        return "manageStudent.ftl";
    }


    /**
     * @Description: 作业管理主界面
     * @Param: null
     * @return: manageHomework.ftl
     * @Author: Yuan Sijian
     * @Date: 20-2-14
     */
    @RequestMapping("manageHomework")
    public String manageHomework(@RequestParam(value = "stuname", defaultValue = "") String stuname, Model model, @RequestParam(value = "homeworkname", defaultValue = "") String homeworkname, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session, @RequestParam(value = "startTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "endTime", defaultValue = "1970-01-01") String endTime)
    {
        PageHelper.startPage(pageNum, pageSize);
        Administrator administrator = (Administrator) session.getAttribute("user");

        if (stuname.equals("") && homeworkname.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01"))
        {
            List<HomeworkWithBLOBs> list = homeworkService.queryAll();
            PageInfo<HomeworkWithBLOBs> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);
        } else
        {
            List<HomeworkWithBLOBs> list = homeworkService.fuzzyQuery(stuname, homeworkname, startTime, endTime);
            PageInfo<HomeworkWithBLOBs> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);
        }


        model.addAttribute("administrator", administrator);

        return "manageHomework.ftl";
    }

    /**
     * @Description: 作业列表
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @RequestMapping("listHomework")
    public String listHomework(Model model, @RequestParam(value = "homeworkname", defaultValue = "") String homeworkname, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session, @RequestParam(value = "startTime", defaultValue = "1970-01-01") String startTime, @RequestParam(value = "endTime", defaultValue = "1970-01-01") String endTime)
    {
        System.out.println("111111111111");

        PageHelper.startPage(pageNum, pageSize);
        Administrator administrator = (Administrator) session.getAttribute("user");

        if (homeworkname.equals("") && startTime.equals("1970-01-01") && endTime.equals("1970-01-01"))
        {
            List<Givehomework> list = givehomeworkService.queryAll();
            PageInfo<Givehomework> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);
        } else
        {
            List<Givehomework> list = givehomeworkService.fuzzyQuery(homeworkname, startTime, endTime);
            PageInfo<Givehomework> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);
        }


        model.addAttribute("administrator", administrator);

        return "listHome.ftl";
    }

    /**
     * @Description: 新增作业
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @RequestMapping("addHomework")
    public String addHomework(HttpSession session, Model model)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        List<Classes1> list = classes1Service.queryUsed();

        model.addAttribute("gradeList", list);
        model.addAttribute("administrator", administrator);


        return "addHomework.ftl";
    }

    /**
     * @Description: 新增作业保存
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @ResponseBody
    @RequestMapping("homeworkAchieve")
    public int homeworkAchieve(Givehomework givehomework, HttpSession session)
    {

        System.out.println(givehomework);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        Administrator administrator = (Administrator) session.getAttribute("user");

        givehomework.setAuthor(administrator.getUsername());
        givehomework.setCreateTime(currentDate);
        givehomework.setIdDelete(0);

        return givehomeworkService.insert(givehomework);
    }

    /**
     * @Description: 编辑作业
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @RequestMapping("editHomework/{id}")
    public String editHomework(HttpSession session, Model model, @PathVariable("id") int id)
    {

        Givehomework givehomework = givehomeworkService.selectByPrimaryKey(id);

        Administrator administrator = (Administrator) session.getAttribute("user");

        List<Classes1> list = classes1Service.queryUsed();

        model.addAttribute("gradeList", list);

        model.addAttribute("administrator", administrator);
        model.addAttribute("homework", givehomework);

        return "editHomework.ftl";
    }

    /**
     * @Description: 更新作业
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @ResponseBody
    @RequestMapping("updateHomework/{id}")
    public int updateHomework(@PathVariable("id") int id, Givehomework givehomework)
    {
        System.out.println(givehomework);

        givehomework.setId(id);

        return givehomeworkService.updateByPrimaryKeySelective(givehomework);
    }

    /**
     * @Description: 删除作业
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-11
     */
    @ResponseBody
    @RequestMapping("deleteHomework/{id}")
    public int deleteHomework(@PathVariable("id") int id)
    {
        Givehomework givehomework = new Givehomework();
        givehomework.setId(id);
        givehomework.setIdDelete(1);

        return givehomeworkService.updateByPrimaryKeySelective(givehomework);
    }

    /**
     * @Description: 班级年级
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @RequestMapping("other")
    public String other(Model model, @RequestParam(value = "keyword", defaultValue = "") String keyword, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        PageHelper.startPage(pageNum, pageSize);

        if (keyword.equals(""))
        {
            List<Classes1> classes1List = classes1Service.queryAll();
            PageInfo<Classes1> pageInfo = new PageInfo(classes1List);
            model.addAttribute("pageInfo", pageInfo);
        } else
        {
            List<Classes1> classes1List = classes1Service.fuzzyQuery(keyword);
            PageInfo<Classes1> pageInfo = new PageInfo(classes1List);
            model.addAttribute("pageInfo", pageInfo);
        }


        model.addAttribute("administrator", administrator);

        return "other.ftl";
    }

    /**
     * @Description: 新增年级
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @RequestMapping("addGrade")
    public String addGrade(Model model, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        model.addAttribute("administrator", administrator);

        return "addGrade.ftl";
    }

    /**
     * @Description: 保存
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @ResponseBody
    @RequestMapping("saveGrade")
    public int saveGrade(Classes1 classes1, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        classes1.setCreater(administrator.getUsername());
        classes1.setCreateTime(main.getDate());
        classes1.setIsDelete(0);

        return classes1Service.insert(classes1);
    }

    /**
     * @Description: 更新年级班级
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @ResponseBody
    @RequestMapping("updateGrade")
    public int updateGrade(@RequestParam("id") int id, @RequestParam("val") int isDelete)
    {
        //        System.out.println("11111111111111");
        //        System.out.println(isDelete);
        //        System.out.println(id);

        Classes1 classes1 = new Classes1();

        if (isDelete == 0)
        {
            isDelete = 1;
        } else
        {
            isDelete = 0;
        }

        classes1.setId(id);
        classes1.setIsDelete(isDelete);

        return classes1Service.updateByPrimaryKeySelective(classes1);
    }

    /**
     * @Description: 编辑年级班级
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @RequestMapping("editGrade/{id}")
    public String editGrade(Model model, HttpSession session, @PathVariable("id") int id)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Classes1 classes1 = classes1Service.selectByPrimaryKey(id);

        model.addAttribute("grade", classes1);
        model.addAttribute("administrator", administrator);

        return "editGrade.ftl";
    }

    /**
     * @Description: 更新年级班级信息
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-18
     */
    @ResponseBody
    @RequestMapping("updateG")
    public int updateG(Classes1 classes1)
    {
        return classes1Service.updateByPrimaryKeySelective(classes1);
    }

    /**
     * @Description: 查看学生作业提交情况
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-22
     */
    @RequestMapping("checkHomework/{id}/{grade}")
    public String checkHomework(@PathVariable("id") int id, Model model, HttpSession session, @PathVariable("grade") String grade)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        List<HashMap> list = studentService.checkHomework(grade);

        String title = givehomeworkService.selectByPrimaryKey(id).getTitle();

        System.out.println(list);

        model.addAttribute("list", list);
        model.addAttribute("administrator", administrator);
        model.addAttribute("title", title);

        return "checkHomework.ftl";
    }

    /**
     * @Description: 作业批改
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-22
     */
    @RequestMapping("correct/{id}")
    public String correct(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("id", id);

        return "correct.ftl";
    }
}
