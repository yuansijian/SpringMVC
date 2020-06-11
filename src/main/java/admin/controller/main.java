package admin.controller;

import admin.generator.entity.*;
import admin.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.coobird.thumbnailator.Thumbnails;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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

import static admin.controller.Community.isexist;

/**
 * @program: SpringMVC
 * @description: 前台界面
 * @author: Yuan Sijian
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Classes1Service classes1Service;
    @Autowired
    private UploadconfigService uploadconfigService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private Download1Service download1Service;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private Short1Service short1Service;
    @Autowired
    private LoginnumberService loginnumberService;


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
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
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
    * @Author: Yuan Sijian
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
    * @Author: Yuan Sijian
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
    * @Author: Yuan Sijian
    * @Date: 20-3-13
    */
    @RequestMapping("information")
    public String information(Model model, HttpSession session)
    {
        Student student = (Student) session.getAttribute("student");

        System.out.println(student.getImageurl());

        model.addAttribute("student", student);

        return "main/information.ftl";
    }

    /**
    * @Description: 更改头像
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-20
    */
    @RequestMapping("changePhoto")
    public String changePhoto(HttpSession session, @RequestParam("imageURL") MultipartFile multipartFile, @RequestParam("id")int id)
    {
        Student student = new Student();
        Student temp = studentService.selectByPrimaryKey(id);

        if(!multipartFile.isEmpty())
        {
            try{
                String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/studentHeader/";

                //获取原文件名
                String name = multipartFile.getOriginalFilename();
                //获取扩展名
                String type = name.substring(name.lastIndexOf(".")+1).toLowerCase();
                String newFileName = id + "." +type;

                File dir = new File(rootPath + newFileName);

                if(!dir.exists())
                {
                    dir.mkdirs();
                }

                multipartFile.transferTo(dir);

                Thumbnails.of(dir).size(68, 68).keepAspectRatio(false).toFile(dir);

                student.setId(id);
                student.setImageurl(newFileName);
                studentService.updateByPrimaryKeySelective(student);

                if(temp.getGrade().equals("teacher"))
                {
                    Teacher teacher = (Teacher)session.getAttribute("teacher");
                    Teacher temp1 = new Teacher();

                    temp1.setId(teacher.getId());
                    temp1.setImageurl(newFileName);

                    System.out.println(teacherService.updateByPrimaryKeySelective(temp1));
                }

                System.out.println("You successfully uploaded file=" +  multipartFile.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        student = studentService.selectByPrimaryKey(id);

        session.setAttribute("student", student);

        return "redirect:/main/information";
    }

    /**
    * @Description: 更新教师信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-23
    */
    @RequestMapping("updateTeaProfile")
    public String updateTeaProfile(Student student, HttpSession session)
    {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Teacher temp = new Teacher();
        temp.setId(teacher.getId());
        temp.setUsername(student.getUsername());
        temp.setTeamail(student.getStumail());

        System.out.println(teacherService.updateByPrimaryKeySelective(temp));

        studentService.updateByPrimaryKeySelective(student);

        student = studentService.selectByPrimaryKey(student.getId());

        session.setAttribute("student",student);

        return "redirect:/main/information";
    }

    /**
    * @Description: 更改个人信息
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-20
    */
    @RequestMapping("updateProfile")
    public String updateProfile(HttpSession session, Student student)
    {

        studentService.updateByPrimaryKeySelective(student);

        student = studentService.selectByPrimaryKey(student.getId());

        session.setAttribute("student",student);

        return "redirect:/main/information";
    }

    /**
    * @Description: 作业中心
    * @Param:
    * @return:
    * @Author: Yuan Sijian
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
    * @Description: 上传作业保存
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-20
    */
    @ResponseBody
    @RequestMapping("saveHomework/{id}")
    public int saveHomework(@RequestParam("file")MultipartFile multipartFile, Model model, HttpSession session,
                            @PathVariable("id") int id, @RequestParam("title")String title)
    {
        {
            //        System.out.println(multipartFile + "123");
//            Uploadfile uploadfile = new Uploadfile();

            System.out.println("1111111111111");
            System.out.println(id);

            HomeworkWithBLOBs homeworkWithBLOBs = new HomeworkWithBLOBs();

            Student student = (Student)session.getAttribute("student");
            //获取文件允许上传的类型
            Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);
            String types = uploadconfig.getType1();
            String []arr = types.split(",");

            //文件扩展名
            String type = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);

            if(!isexist(arr, type))
            {
                return 303;
                //            return "redirect:/error500";
            }

            if(multipartFile.getSize() > 204800000)
            {
                return 202;
                //            return "redirect:/error500";
            }


            if(!multipartFile.isEmpty())
            {
                try
                {
                    String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/homework";

                    File dir = new File(rootPath + File.separator);

                    if(!dir.exists())
                    {
                        dir.mkdirs();
                    }

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                    String currentDate = simpleDateFormat.format(date);

                    File serverFile = new File(dir.getAbsolutePath() + File.separator + (currentDate+multipartFile.getOriginalFilename()));



                    homeworkWithBLOBs.setFileurl(currentDate+multipartFile.getOriginalFilename());
                    homeworkWithBLOBs.setGivehomeid(id);
                    homeworkWithBLOBs.setStudent(student.getStunumber());
                    homeworkWithBLOBs.setStuname(student.getStuname());
                    homeworkWithBLOBs.setUploadtime(currentDate);
                    homeworkWithBLOBs.setTitle(title);

                    //                System.out.println(uploadfile);
                    multipartFile.transferTo(serverFile);

                    System.out.println("You successfully uploaded file=" +  multipartFile.getOriginalFilename());

                    if(homeworkService.insert(homeworkWithBLOBs) == 1)
                    {
                        return 1;
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            return 0;
        }
    }

    /**
    * @Description: 留言功能
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-15
    */
    @RequestMapping("message")
    public String message(Model model, HttpSession session,
                          @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
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
        Student student = (Student)session.getAttribute("student");
        PageHelper.startPage(pageNum, pageSize);
        List<CommentWithBLOBs> comment = commentService.queryAll();
        List<CommentParentChild> reply = commentParentChildService.queryAll();
        PageInfo<CommentWithBLOBs> pageInfo = new PageInfo(comment);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("reply", reply);
        model.addAttribute("student", student);

        return "main/message.ftl";
    }

    /**
    * @Description: 留言点赞功能
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-3
    */
    @ResponseBody
    @RequestMapping("commentGood")
    public int good()
    {
        return 0;
    }
    /**
    * @Description: 回复消息
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-20
    */
    @RequestMapping("news/{username}")
    public String news(Model model, HttpSession session, @PathVariable("username")String username)
    {
        List<CommentParentChild> list = commentParentChildService.queryByUsername(username);

        Student student = (Student)session.getAttribute("student");

        model.addAttribute("news", list);
        model.addAttribute("student", student);

        return "main/news.ftl";
    }

    /**
    * @Description: 新增留言
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-15
    */
    @ResponseBody
    @RequestMapping("addMessage")
    public int addMessage(@RequestParam("message")String message, HttpSession session)
    {

        Student student = (Student)session.getAttribute("student");

        CommentWithBLOBs comment = new CommentWithBLOBs();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);

        comment.setCommenttime(currentDate);
        comment.setIsDelete(0);
        comment.setComment(message);
        comment.setUid(1);
        comment.setUsername(student.getUsername());
        comment.setFlag(0);
        comment.setUp(0);
        comment.setCommenturl(student.getImageurl());

        return commentService.insert(comment);
    }
    
    /**
    * @Description: 新增主楼下回复
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-16
    */
    @ResponseBody
    @RequestMapping("addReply")
    public int addReply(Model model, HttpSession session, CommentParentChild commentParentChild)
    {
        Student student = (Student)session.getAttribute("student");

        commentParentChild.setCreatTime(getDate());
        commentParentChild.setFlag(0);
        commentParentChild.setIsDelete(0);
        commentParentChild.setUp(0);
        commentParentChild.setUsername(student.getUsername());

        return commentParentChildService.insert(commentParentChild);
    }

    /**
    * @Description: 登录
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-17
    */
    @ResponseBody
    @RequestMapping("login")
    public int login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session)
    {
//        System.out.println(username+password);

        Student student = studentService.queryUsernameAndPassword(username, password);


//        System.out.println(student.getUsername()+student.getPassword());

        if(student.getUsername().equals(username) && student.getPassword().equals(password))
        {
            //当天活跃度
            Loginnumber loginnumber = loginnumberService.selectByPrimaryKey(1);
            int countLogin = loginnumber.getCount()+1;
            Loginnumber loginnumber1 = new Loginnumber();
            loginnumber1.setCount(countLogin);
            loginnumber1.setId(1);
            loginnumberService.updateByPrimaryKeySelective(loginnumber1);

            Student temp = new Student();
            temp.setLogintime(getDate());
            //记录学生登录次数
            temp.setLoginnumber(student.getLoginnumber()+1);
            temp.setId(student.getId());
            System.out.println(studentService.updateByPrimaryKeySelective(temp));

            student.setLogintime(getDate());
            session.setAttribute("student", student);
            //教师登录学生端
            if(student.getGrade().equals("teacher"))
            {
                Teacher temp1 = new Teacher();
                Teacher teacher = teacherService.queryUsernameAndPassword(username, password);
                System.out.println(2);
                temp1.setId(teacher.getId());
                temp1.setLogintime(getDate());
                temp1.setLoginnumber(teacher.getLoginnumber()+1);
                System.out.println(3);
                System.out.println(teacherService.updateByPrimaryKeySelective(temp1));
                System.out.println(4);

                teacher.setLogintime(getDate());
                session.setAttribute("teacher", teacher);
            }
            return 1;
        }
        return 0;
    }

    /**
    * @Description: 注册
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-17
    */
    @RequestMapping("signupstu")
    public String signup(Model model)
    {
        List<Classes1> list = classes1Service.queryUsed();

        model.addAttribute("gradeList", list);

        return "main/signupstu.ftl";
    }
    @RequestMapping("signuptea")
    public String signuptea()
    {
        return "main/signuptea.ftl";
    }

    /**
    * @Description: 注册保存
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-17
    */
    @ResponseBody
    @RequestMapping("saveStudent")
    public int saveStudent(Student student)
    {
        System.out.println(student);

        student.setIsDelete(0);
        student.setRegisteredtime(getDate());
        student.setLogintime(getDate());
        student.setLoginnumber(1);
        student.setEndtime("");
        System.out.println(student);
//        System.out.println();

        return studentService.insert(student);
    }
    @ResponseBody
    @RequestMapping("saveTeacher")
    public int saveTeacher(Teacher teacher)
    {
        Student student = new Student();

        long num = System.currentTimeMillis();

        student.setLoginnumber(0);
        student.setRegisteredtime(getDate());
        student.setIsDelete(0);
        student.setImageurl("4.jpg");
        student.setGrade("teacher");
        student.setPassword(teacher.getPassword());
        student.setUsername(teacher.getUsername());
        student.setStuname(teacher.getTeaname());
        student.setStunumber(String.valueOf(num));
        student.setStumail(teacher.getTeamail());
        student.setSex(teacher.getSex());
        student.setStuphone("11111111111");
        System.out.println(studentService.insert(student));

        teacher.setIsDelete(2);//审核
        teacher.setRegisteredtime(getDate());
        teacher.setLoginnumber(1);
        teacher.setLogintime(getDate());
        teacher.setGrade("无");
        teacher.setEndtime("");

        return teacherService.insert(teacher);
    }

    /**
    * @Description: 练习中心
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @RequestMapping("practice")
    public String practice(Model model, HttpSession session,
                           @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "25")int pageSize,
                           @RequestParam(value = "id", defaultValue = "0")int id)
    {
//        PageHelper.startPage(pageNum, pageSize);
//
//        System.out.println("id="+id);
//
//        List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
//        PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
//        model.addAttribute("pageInfo", pageInfo);
//
//        model.addAttribute("ids", id);
//        System.out.println("id="+id);
//
//
//        return "main/main.ftl"

        PageHelper.startPage(pageNum, pageSize);

        List<Short1WithBLOBs> short1WithBLOBs = short1Service.queryAll();
        PageInfo<Short1WithBLOBs> pageInfo = new PageInfo(short1WithBLOBs);

//        List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
//        PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);

        model.addAttribute("pageInfo", pageInfo);
//
        model.addAttribute("ids", id);
        System.out.println("id="+id);
        System.out.println("111111111111111");



        return "main/practice.ftl";
    }

    /**
    * @Description: 联系答案
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-19
    */
    @RequestMapping("practiceText/{id}")
    public String practiceText(@PathVariable("id")int id, Model model)
    {
        PageHelper.startPage(1, 25);

        List<Short1WithBLOBs> short1WithBLOBs = short1Service.queryAll();
        PageInfo<Short1WithBLOBs> pageInfo = new PageInfo(short1WithBLOBs);

//        List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
//        PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
        model.addAttribute("pageInfo", pageInfo);


        Short1WithBLOBs short1WithBLOBs1 = short1Service.selectByPrimaryKey(id);

        String type = short1WithBLOBs1.getImageurl();
        String pictures[] = type.split(",");

        model.addAttribute("pictureTeacher", short1WithBLOBs1);
        model.addAttribute("pictures", pictures);

        return "main/practiceText.ftl";
    }

    /**
    * @Description: 退出
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-20
    */
    @ResponseBody
    @RequestMapping("logout")
    public int logout(HttpSession session)
    {
        Student temp = new Student();
        Student student = (Student)session.getAttribute("student");
        temp.setEndtime(getDate());
        temp.setId(student.getId());
        studentService.updateByPrimaryKeySelective(temp);

        if(student.getGrade().equals("teacher"))
        {
            Teacher teacher = (Teacher)session.getAttribute("teacher");
            Teacher temp1 = new Teacher();
            temp1.setId(teacher.getId());
            temp1.setEndtime(getDate());

            teacherService.updateByPrimaryKeySelective(temp1);
        }
        session.invalidate();

        return 1;
    }
    
    /**
    * @Description: 视频教学
    * @Param: 
    * @return: 
    * @Author: Yuan Sijian
    * @Date: 20-3-24
    */
    @RequestMapping("videoTeacher")
    public String videoTeacher(@RequestParam(value = "startTime", defaultValue = "1970-01-01")String startTime, Model model, HttpSession session,
                               @RequestParam(value = "endTime", defaultValue = "1970-01-01")String endTime, @RequestParam(value = "vname", defaultValue = "")String vname,
                               @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);

        if(startTime.equals("1970-01-01") && endTime.equals("1970-01-01")&&vname.equals(""))
        {
            List<VideoWithBLOBs> videoList = videoService.queryAll();
            PageInfo<Student> pageInfo = new PageInfo(videoList);
            model.addAttribute("pageInfo", pageInfo);

        }
        else
        {
            List<VideoWithBLOBs> videoList = videoService.fuzzyQuery(startTime, endTime, vname);
            PageInfo<Student> pageInfo = new PageInfo(videoList);
            model.addAttribute("pageInfo", pageInfo);
        }



        return "main/videoTeacher.ftl";
    }

    /**
     * @Description: 视频观看
     * @Param:
     * @return:
     * @Author: Yuan Sijian
     * @Date: 20-3-8
     */
    @RequestMapping("videoWatch/{id}")
    public String videoPreview(Model model, HttpSession session, @PathVariable("id")int id)
    {

        VideoWithBLOBs videoWithBLOBs = videoService.selectByPrimaryKey(id);

        model.addAttribute("video", videoWithBLOBs);

        return "main/videoWatch.ftl";
    }

    /**
    * @Description: 更新下载数
    * @Param:
    * @return:
    * @Author: Yuan Sijian
    * @Date: 20-3-30
    */
    @ResponseBody
    @RequestMapping("updateDownload")
    public int updateDownload()
    {
        System.out.println(1111);
        Download1 download1 = new Download1();

        Download1 download11 = download1Service.selectByPrimaryKey(1);

//        System.out.println(download11.getCount2());

        int temp = download11.getCount2() + 1;

        download1.setId(1);
        download1.setCount2(temp);

        return download1Service.updateByPrimaryKeySelective(download1);
    }

}
