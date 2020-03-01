package admin.controller;

import admin.generator.entity.Administrator;
import admin.generator.entity.Systempicture;
import admin.generator.entity.Uploadconfig;
import admin.generator.entity.Uploadfile;
import admin.service.SystempictureService;
import admin.service.UploadconfigService;
import admin.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.File;


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
    private SystempictureService systempictureService;
    @Autowired
    private UploadconfigService uploadconfigService;
    @Autowired
    private UploadfileService uploadfileService;

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
    public String baseConfig(Model model, HttpSession session)
    {
        Systempicture systempicture = systempictureService.selectByPrimaryKey(1);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
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
    public String systemConfig(Model model, HttpSession session)
    {
        String system = System.getProperty("os.name");



        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
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
    public String uploadConfig(Model model, HttpSession session)
    {
        Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);

//        System.out.println(uploadconfig);
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
        model.addAttribute("uploadconfig", uploadconfig);

        return "uploadConfig.ftl";
    }

    /**
    * @Description: 上传配置更新
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-29
    */
    @RequestMapping("uploadUpdate")
    public String uploadUpdate(Uploadconfig uploadconfig, Model model, HttpSession session)
    {
        uploadconfig.setId(1);

        System.out.println(uploadconfig);

        System.out.println(uploadconfigService.updateByPrimaryKeySelective(uploadconfig));

        uploadconfig = uploadconfigService.selectByPrimaryKey(1);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        model.addAttribute("uploadconfig", uploadconfig);

        return "uploadConfig.ftl";
    }

    /**
    * @Description: 文件上传功能
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-1
    */
    @RequestMapping("uploadFile")
    public String uploadFile(Model model, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "uploadFile.ftl";
    }
    /**
    * @Description: 上传文件保存
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-1
    */
    @RequestMapping("uploadFileAchieve")
    public String test(@RequestParam("file")MultipartFile multipartFile, Model model, HttpSession session)
    {
//        System.out.println(multipartFile + "123");
        Uploadfile uploadfile = new Uploadfile();



        if(!multipartFile.isEmpty())
        {
            try
            {
                String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/uploadFile";

                File dir = new File(rootPath + File.separator);

                if(!dir.exists())
                {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());

                //将上传文件的信息插入数据库
                uploadfile.setFilename(multipartFile.getOriginalFilename());
                uploadfile.setFilesize((int)multipartFile.getSize());
                uploadfile.setFileurl(rootPath);
                uploadfile.setIsDelete(0);
                System.out.println(uploadfileService.insert(uploadfile));
//                System.out.println(uploadfile);

                multipartFile.transferTo(serverFile);

                System.out.println("You successfully uploaded file=" +  multipartFile.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "uploadFile.ftl";
    }
    
    /**
    * @Description: 上传图片
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-1
    */
    
    
}
