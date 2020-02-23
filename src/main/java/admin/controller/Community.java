package admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringMVC
 * @description: 社区管理
 * @author: Defend
 * @create: 2020-02-14 18:02
 **/
@Controller
@RequestMapping("community")
public class Community
{
    /**
    * @Description: 用户管理
    * @Param: null
    * @return: manageUser.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("manageUser.ftl")
    public String manageUser()
    {
        return "manageUser.ftl";
    }
    
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
    @RequestMapping("registrationMaintenance.ftl")
    public String registrationMaintenance()
    {
        return "registrationMaintenance.ftl";
    }

    /**
    * @Description: 权限管理
    * @Param: null
    * @return: authorityControl.ftl
    * @Author: Defend
    * @Date: 20-2-14
    */
    @RequestMapping("authorityControl.ftl")
    public String authorityControl()
    {
        return "authorityControl.ftl";
    }

}
