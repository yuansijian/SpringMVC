package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringMVC
 * @description: 用户
 * @author: Defend
 * @create: 2020-02-10 22:44
 **/
@Controller
@RequestMapping("user")
public class User
{

    /**
    * @Description: 新用户
    * @Param: null
    * @return: newuser.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("newuser")
    public String newuser()
    {

        return "newuser.ftl";
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
    public String studentInformation()
    {
        return "studentInformation.ftl";
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
}
