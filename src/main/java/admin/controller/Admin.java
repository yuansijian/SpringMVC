package admin.controller;



import admin.generator.entity.User;
import admin.service.StudentService;
import admin.service.TeacherService;
import admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @program: SpringMVC
 * @description: 后台主界面
 * @author: Defend
 * @create: 2020-02-14 16:37
 **/
@Controller
public class Admin
{
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
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
        int id = 2;

        User user = userService.selectByPrimaryKey(id);

        String name = user.getName();

        long count = teacherService.selectByCountPrimaryKey() + studentService.selectByCountPrimaryKey();

        model.addAttribute("count", count);


        return "index.ftl";
    }

}
