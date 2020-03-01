package admin.controller;



import admin.generator.entity.Administrator;
import admin.service.AdministratorService;
import admin.service.StudentService;
import admin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
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
@SessionAttributes("user")
public class Admin
{
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdministratorService administratorService;

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
    public String index(Model model, HttpSession session)
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        Administrator administrator = (Administrator) session.getAttribute("user");

        String monday = dateFormat.format(getThisWeekMonday(date));
        String sunday = dateFormat.format(getThisWeekSunday(date));

        //        Date monday = getThisWeekMonday(date);
        //        Date sunday = getThisWeekSunday(date);


        long count = teacherService.selectByCountPrimaryKey() + studentService.selectByCountPrimaryKey();

        List<HashMap> hashMapList= studentService.registeredQuery(monday, sunday);


        model.addAttribute("count", count);
        model.addAttribute("hashMapList", hashMapList);
        model.addAttribute("administrator", administrator);


        return "index.ftl";

    }

    /**
    * @Description: 登录界面
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-1
    */
    @RequestMapping("adminLogin")
    public String login()
    {
        return "adminLogin.ftl";
    }

    /**
    * @Description: 登录验证跳转
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-1
    */
    @RequestMapping("redirect")
    public String redirect(Model model, @RequestParam("username")String username,
                           @RequestParam("password")String password, HttpSession session)
    {
        Administrator administrator = administratorService.queryByUsernameAndPassword(username, password);

        if(administrator.getUsername().equals(username) && administrator.getPassword().equals(password))
        {
            session.setAttribute("user", administrator);

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
            model.addAttribute("administrator", administrator);

            return "index.ftl";
        }

        return "error.html";
    }


}
