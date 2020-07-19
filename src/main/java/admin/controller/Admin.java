package admin.controller;


import admin.generator.entity.Administrator;
import admin.generator.entity.Teacher;
import admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @program: SpringMVC
 * @description: 后台主界面
 * @author: Yuan Sijian
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentParentChildService commentParentChildService;
    @Autowired
    private Download1Service download1Service;
    @Autowired
    private LoginnumberService loginnumberService;

    /**
     * @Description: 获取本周第一天
     * @Param: date
     * @return: 本周第一天日期 YYYY-MM-dd
     * @Author: Yuan Sijian
     * @Date: 20-2-26
     */
    public static Date getThisWeekMonday(Date date)
    {
        Calendar cal = Calendar.getInstance();
        try
        {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return cal.getTime();
    }

    /**
     * @Description: 获取本周最后一天
     * @Param: date
     * @return: 本周最后一天日期 YYYY-MM-dd
     * @Author: Yuan Sijian
     * @Date: 20-2-26
     */
    public static Date getThisWeekSunday(Date date)
    {
        Calendar cal = Calendar.getInstance();

        try
        {
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 6);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return cal.getTime();
    }

    /**
     * @Description: 获取每月的第一天
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-4
     */
    public static String getFirstDayOfMonth(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }


    /**
     * @Description: 获取某月的最后一天
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-4
     */
    public static String getLastDayOfMonth(int year, int month)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        return format.format(calendar.getTime());
    }

    /**
     * @Description: 获得当天日期
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-16
     */
    public static String getDate()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);

        return currentDate;
    }


    /**
     * @Description: 主界面
     * @Param: null
     * @return: index.ftl
     * @Author: Yuan Sijian
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

        //新增留言
        String currentDate = getDate();
        int add = commentService.addMessage(currentDate, currentDate) + commentParentChildService.addMessage(currentDate, currentDate);


        //统计下载
        int downlodNumber = download1Service.selectByPrimaryKey(1).getCount2();

        //一周内注册统计
        long count = teacherService.selectByCountPrimaryKey() + studentService.selectByCountPrimaryKey();
        List<Integer> list = studentService.registeredQuery(monday, sunday);
        int arr[] = {0, 0, 0, 0, 0, 0, 0};
        int j = 0;
        for (; j < list.size(); j++)
        {
            arr[j] = list.get(j);
        }

        //        System.out.println(list.get(1));

        //活跃度统计
        SimpleDateFormat year = new SimpleDateFormat("YYYY");
        int currentYear = Integer.parseInt(year.format(date));
        int months[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int activitys[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 12; i++)
        {
            activitys[i] = studentService.queryCountLogin(getFirstDayOfMonth(currentYear, months[i]), getLastDayOfMonth(currentYear, months[i]));
        }

        //今日活跃度
        int activity = loginnumberService.selectByPrimaryKey(1).getCount();


        model.addAttribute("count", count);
        model.addAttribute("hashMapList", arr);
        model.addAttribute("administrator", administrator);
        model.addAttribute("activity", activitys);
        model.addAttribute("activite", activity);
        model.addAttribute("add", add);
        model.addAttribute("downloadNumber", downlodNumber);


        return "index.ftl";

    }

    /**
     * @Description: 登录界面
     * @Param:
     * @return:
     * @Author: Yuan Sijian
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
     * @Author: Yuan Sijian
     * @Date: 20-3-1
     */
    @ResponseBody
    @RequestMapping("redirect")
    public int redirect(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session)
    {
        Administrator administrator = administratorService.queryByUsernameAndPassword(username, password);

        //        System.out.println(administrator);
        //        System.out.println(administrator.getUsername());

        Administrator temp = new Administrator();

        temp.setId(administrator.getId());
        temp.setLogintime(getDate());
        temp.setLoginnumber(administrator.getLoginnumber() + 1);

        administratorService.updateByPrimaryKeySelective(temp);

        if (administrator.getUsername().equals(username) && administrator.getPassword().equals(password))
        {
            session.setAttribute("user", administrator);
            //
            //            Date date = new Date();
            //            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            //
            //            String monday = dateFormat.format(getThisWeekMonday(date));
            //            String sunday = dateFormat.format(getThisWeekSunday(date));
            //
            //            //        Date monday = getThisWeekMonday(date);
            //            //        Date sunday = getThisWeekSunday(date);
            //
            //            //记录用户登录信息
            //            Administrator temp = new Administrator();
            //            temp.setLoginnumber(administrator.getLoginnumber()+1);
            //            temp.setLogintime(dateFormat.format(date));
            //            temp.setId(administrator.getId());
            //            administratorService.updateByPrimaryKeySelective(temp);
            //
            //
            //
            //
            //            //注册用户查看
            //            long count = teacherService.selectByCountPrimaryKey() + studentService.selectByCountPrimaryKey();
            //            List<Integer> list= studentService.registeredQuery(monday, sunday);
            //
            //            //活跃度统计
            //            SimpleDateFormat year = new SimpleDateFormat("YYYY");
            //            int currentYear = Integer.parseInt(year.format(date));
            //            int months[]  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            //            int activitys[] = new int[12];
            //            for(int i=0; i<12; i++)
            //            {
            //                activitys[i] = studentService.queryCountLogin(getFirstDayOfMonth(currentYear, months[i]), getLastDayOfMonth(currentYear, months[i]));
            //            }
            //
            //
            //
            //            model.addAttribute("activity", activitys);
            //            model.addAttribute("count", count);
            //            model.addAttribute("hashMapList", list);
            //            model.addAttribute("administrator", administrator);

            return 1;
        }

        return 0;
    }

    /**
     * @Description: 登出
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-3
     */
    @RequestMapping("loginOut")
    public String loginout(HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Administrator temp = new Administrator();

        temp.setId(administrator.getId());
        temp.setEndtime(getDate());

        administratorService.updateByPrimaryKeySelective(temp);

        if (administrator.getAuthority() == 2)
        {
            Teacher teacher = teacherService.queryUsernameAndPassword(administrator.getUsername(), administrator.getPassword());

            Teacher temp1 = new Teacher();

            temp1.setId(teacher.getId());
            temp1.setEndtime(getDate());

            teacherService.updateByPrimaryKeySelective(temp1);

        }

        session.invalidate();

        return "redirect:/adminLogin";
    }


    /**
     * @Description: 错误界面
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-4
     */
    @RequestMapping("error")
    public String errorPage()
    {
        return "error.html";
    }

    /**
     * @Description: 500错误界面
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-5
     */
    @RequestMapping("error500")
    public String error500(Model model)
    {
        model.addAttribute("b", 1);

        return "main/login.ftl";
    }


}
