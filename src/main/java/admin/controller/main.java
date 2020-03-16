package admin.controller;

import admin.generator.entity.*;
import admin.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: SpringMVC
 * @description: 前台界面
 * @author: Defend
 * @create: 2020-03-12 15:20
 **/
@CrossOrigin
@Controller
@RequestMapping("main")
public class main
{
    @Autowired
    private PictureteacherService pictureteacherService;
    @Autowired
    private UploadfileService uploadfileService;
    @Autowired
    private GivehomeworkService givehomeworkService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentParentChildService commentParentChildService;

    /**
    * @Description: 获得当天日期
    * @Param:
    * @return:
    * @Author: Defend
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
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-13
    */
    @RequestMapping("index")
    public String main(Model model, HttpSession session,
                       @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "25")int pageSize,
                       @RequestParam(value = "id", defaultValue = "0")int id)
    {
        PageHelper.startPage(pageNum, pageSize);

        System.out.println("id="+id);

        List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
        PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("ids", id);
        System.out.println("id="+id);


        return "main/main.ftl";
    }

    /**
    * @Description: 图文教学
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-13
    */
    @RequestMapping("picture/{id}")
    public String picture(@PathVariable("id")int id, Model model, HttpSession session)
    {
//        System.out.println(id);

        PageHelper.startPage(1, 25);

        List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
        PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
        model.addAttribute("pageInfo", pageInfo);


        Pictureteacher pictureteacher = pictureteacherService.selectByPrimaryKey(id);

        String type = pictureteacher.getPictureurl();
        String pictures[] = type.split(",");

        model.addAttribute("pictureTeacher", pictureteacher);
        model.addAttribute("pictures", pictures);

        return "main/picture.ftl";
    }
    
    /**
    * @Description: 资源中心
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-13
    */
    @RequestMapping("resource")
    public String resource(Model model, HttpSession session,
                           @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "25")int pageSize)
    {

        PageHelper.startPage(pageNum, pageSize);

        List<Uploadfile> uploadfileList = uploadfileService.queryAll();

        PageInfo<Uploadfile> pageInfo = new PageInfo(uploadfileList);

        model.addAttribute("pageInfo", pageInfo);

        return "main/resource.ftl";
    }

    /**
    * @Description: 个人中心
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-13
    */
    @RequestMapping("information")
    public String information()
    {
        return "main/information.ftl";
    }

    /**
    * @Description: 作业中心
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-13
    */
    @RequestMapping("homework")
    public String homework(Model model, HttpSession session,
                           @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "25")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);

        List<Givehomework> list = givehomeworkService.queryAll();

        PageInfo<Givehomework> pageInfo = new PageInfo(list);

        model.addAttribute("pageInfo", pageInfo);

        return "main/homework.ftl";
    }

    /**
    * @Description: 留言功能
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-15
    */
    @RequestMapping("message")
    public String message(Model model, HttpSession session,
                          @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "25")int pageSize)
    {
//        if(!message.equals(""))
//        {
//            CommentWithBLOBs comment = new CommentWithBLOBs();
//
//            Date date = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
//            String currentDate = simpleDateFormat.format(date);
//
//            comment.setCommenttime(currentDate);
//            comment.setIsDelete(0);
//            comment.setComment(message);
//            comment.setUid(1);
//            comment.setUsername("admin");
//
//            System.out.println(commentService.insert(comment));
//        }

        PageHelper.startPage(pageNum, pageSize);
        List<CommentWithBLOBs> comment = commentService.queryAll();
        List<CommentParentChild> reply = commentParentChildService.queryAll();
        PageInfo<CommentWithBLOBs> pageInfo = new PageInfo(comment);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("reply", reply);

        return "main/message.ftl";
    }

    /**
    * @Description: 新增留言
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-15
    */
    @ResponseBody
    @RequestMapping("addMessage")
    public int addMessage(@RequestParam("message")String message)
    {
        System.out.println("111111111111111111");
        System.out.println(message);


        CommentWithBLOBs comment = new CommentWithBLOBs();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);

        comment.setCommenttime(currentDate);
        comment.setIsDelete(0);
        comment.setComment(message);
        comment.setUid(1);
        comment.setUsername("admin");
        comment.setFlag(0);

        return commentService.insert(comment);
    }
    
    /**
    * @Description: 新增回复
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-16
    */
    @ResponseBody
    @RequestMapping("addReply")
    public int addReply(Model model, HttpSession session, CommentParentChild commentParentChild)
    {

        commentParentChild.setCreatTime(getDate());
        commentParentChild.setFlag(0);
        commentParentChild.setIsDelete(0);

        return commentParentChildService.insert(commentParentChild);
    }

}
