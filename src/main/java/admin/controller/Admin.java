package admin.controller;



import admin.generator.entity.User;
import admin.service.StudentService;
import admin.service.TeacherService;
import admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @program: SpringMVC
 * @description: 后台主界面
 * @author: Defend
 * @create: 2020-02-14 16:37
 **/
@Controller
@CrossOrigin
public class Admin
{
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    /**
    * @Description: 获取本周第一天
    * @Param: date
    * @return: 本周第一天日期 YYYY-MM-dd
    * @Author: Defend
    * @Date: 20-2-26
    */
    public static Date getThisWeekMonday(Date date)
    {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cal.getTime();
    }
    /**
    * @Description: 获取本周最后一天
    * @Param: date
    * @return: 本周最后一天日期 YYYY-MM-dd
    * @Author: Defend
    * @Date: 20-2-26
    */
    public static Date getThisWeekSunday(Date date)
    {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return cal.getTime();
    }


    /**
     * @Description: 主界面
     * @Param: null
     * @return: index.ftl
     * @Author: Defend
     * @Date: 20-2-14
     */
    @RequestMapping("index")
    public String index(Model model)
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        String monday = dateFormat.format(getThisWeekMonday(date));
        String sunday = dateFormat.format(getThisWeekSunday(date));

//        Date monday = getThisWeekMonday(date);
//        Date sunday = getThisWeekSunday(date);


        long count = teacherService.selectByCountPrimaryKey() + studentService.selectByCountPrimaryKey();

        List<HashMap> hashMapList= studentService.registeredQuery(monday, sunday);


        model.addAttribute("count", count);
        model.addAttribute("hashMapList", hashMapList);

        return "index.ftl";
    }

    @RequestMapping("adminLogin")
    public String login()
    {
        return "adminLogin.ftl";
    }

}
