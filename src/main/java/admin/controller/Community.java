package admin.controller;

import admin.generator.entity.Student;
import admin.generator.entity.Systempicture;
import admin.generator.entity.Teacher;
import admin.service.StudentService;
import admin.service.SystempictureService;
import admin.service.TeacherService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: SpringMVC
 * @description: 社区管理
 * @author: Defend
 * @create: 2020-02-14 18:02
 **/
@Controller
@RequestMapping("community")
@CrossOrigin
public class Community
{
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SystempictureService systempictureService;
    /**
    * @Description: 用户管理
    * @Param: null
    * @return: manageUser.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
//    @RequestMapping("manageUser.ftl")
//    public String manageUser(Model model)
//    {
//        List<Student> studentList = studentService.queryAll();
//        List<Teacher> teacherList = teacherService.queryAll();
//
//        model.addAttribute("studentList", studentList);
//        model.addAttribute("teacherList", teacherList);
//
//        return "manageUser.ftl";
//    }
    
    /**
    * @Description: 视频教学
    * @Param: null
    * @return: videoTeacher.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("videoTeacher")
    public String videoTeacher()
    {
        return "videoTeacher.ftl";
    }

    /**
    * @Description: 图片教学
    * @Param: null
    * @return: pictureTeacher.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("pictureTeacher")
    public String pictureTeacher()
    {
        return "pictureTeacher.ftl";
    }

    /**
    * @Description: 文字教学
    * @Param: null
    * @return:
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("wordTeacher")
    public String wordTeacher()
    {
        return "wordTeacher.ftl";
    }

    /**
    * @Description: 简答题库
    * @Param: null
    * @return: shortAnswerDatabase.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("shortAnswerDatabase")
    public String shortAnswerDatabase()
    {
        return "shortAnswerDatabase.ftl";
    }

    /**
    * @Description: 选择题库
    * @Param: null
    * @return: chooseDatabase.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("chooseDatabase.ftl")
    public String chooseDatabase()
    {
        return "chooseDatabase.ftl";
    }

    /**
    * @Description: 注册维护
    * @Param: null
    * @return: registrationMaintenance.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
//    @RequestMapping("registrationMaintenance")
//    public String registrationMaintenance()
//    {
//        return "registrationMaintenance.ftl";
//    }

    /**
    * @Description: 权限管理
    * @Param: null
    * @return: authorityControl.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
//    @RequestMapping("authorityControl")
//    public String authorityControl()
//    {
//        return "authorityControl.ftl";
//    }

    /**
    * @Description: 网站基本配置
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-25
    */
    @RequestMapping("baseConfig")
    public String baseConfig(Model model)
    {
        Systempicture systempicture = systempictureService.selectByPrimaryKey(1);

        model.addAttribute("logoPicturePath", systempicture);

        return "baseConfig.ftl";
    }
    
    /**
    * @Description: 网站系统配置
    * @Param: 
    * @return: systemConfig.ftl
    * @Author: Defend
    * @Date: 20-2-25
    */
    @RequestMapping("systemConfig")
    public String systemConfig(Model model)
    {
        String system = System.getProperty("os.name");



        model.addAttribute("system", system);

        return "systemConfig.ftl";
    }

    /**
    * @Description: 网站上传配置
    * @Param: model
    * @return: uploadConfig
    * @Author: Defend
    * @Date: 20-2-25
    */
    @RequestMapping("uploadConfig")
    public String uploadConfig(Model model)
    {


        return "uploadConfig.ftl";
    }

}
