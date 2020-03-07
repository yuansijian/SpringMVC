package admin.controller;

import admin.generator.entity.*;
import admin.service.PictureteacherService;
import admin.service.SystempictureService;
import admin.service.UploadconfigService;
import admin.service.UploadfileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    private SystempictureService systempictureService;
    @Autowired
    private UploadconfigService uploadconfigService;
    @Autowired
    private UploadfileService uploadfileService;
    @Autowired
    private PictureteacherService pictureteacherService;

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
    public String pictureTeacher(@RequestParam(value = "startTime", defaultValue = "1970-01-01")String startTime, Model model, HttpSession session,
                                 @RequestParam(value = "endTime", defaultValue = "1970-01-01")String endTime, @RequestParam(value = "name", defaultValue = "")String pname,
                                 @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "1")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        if(startTime.equals("1970-01-01") && endTime.equals("1970-01-01")&&pname.equals(""))
        {
            List<Pictureteacher> pictureteacherList = pictureteacherService.queryAll();
            PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
            model.addAttribute("pageInfo", pageInfo);

        }
        else
        {
            List<Pictureteacher> pictureteacherList = pictureteacherService.fuzzySearch(startTime, endTime, pname);
            PageInfo<Pictureteacher> pageInfo = new PageInfo(pictureteacherList);
            model.addAttribute("pageInfo", pageInfo);
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "pictureTeacher.ftl";
    }

    /**
    * @Description: 新增图文教学
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-6
    */
    @RequestMapping("addPictureTeacher")
    public String addPictureTeacher(Model model, HttpSession session)
    {

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "addPictureTeacher.ftl";
    }

    /**
    * @Description: 图文教学保存
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-6
    */
    @RequestMapping("pictureTeacherAchieve")
    public String pictureTeacherAchieve(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                                        @RequestParam(value = "description", defaultValue = "")String word,
                                        @RequestParam(value = "pname", defaultValue = "")String pname)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        if(multipartFile.length >= 1)
        {
//            System.out.println("111111111111111111");
            Pictureteacher pictureteacher = new Pictureteacher();


            //将图片上传到服务器
            String fileName = "";
            for(int i=0; i<multipartFile.length; i++)
            {
                fileName = fileName + "," + multipartFile[i].getOriginalFilename();
                try
                {
                    String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/pictureTeacher";

                    File dir = new File(rootPath + File.separator);

                    if(!dir.exists())
                    {
                        dir.mkdirs();
                    }

                    File serverFile = new File(dir.getAbsolutePath() + File.separator + (multipartFile[i].getOriginalFilename()));


                    multipartFile[i].transferTo(serverFile);

                    System.out.println("You successfully uploaded file=" +  multipartFile[i].getOriginalFilename());


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //将上传文件的信息插入数据库
            if(word.equals(""))
            {
                word = "NULL";
            }

            pictureteacher.setWorld(word);
            pictureteacher.setPname(pname);
            pictureteacher.setPictureurl(fileName);
            pictureteacher.setIsDelete(0);
            pictureteacher.setAuthor(administrator.getUsername());
            pictureteacher.setCreatetime(currentDate);
            pictureteacher.setUpdater(administrator.getUsername());
            pictureteacher.setUpdatetime(currentDate);
            if(pictureteacherService.insert(pictureteacher) == 0)
            {
                return "redirect:/error500";
            }

        }

        model.addAttribute("administrator", administrator);

        return "redirect:/community/addPictureTeacher";
    }

    /**
    * @Description: 图文教学删除
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-7
    */
    @RequestMapping("deletePictureTeacher/{id}")
    public String deletePictureTeacher(@PathVariable("id")int id)
    {
        Pictureteacher pictureteacher = new Pictureteacher();
        pictureteacher.setId(id);
        pictureteacher.setIsDelete(1);

        if(pictureteacherService.updateByPrimaryKeySelective(pictureteacher) == 0)
        {
            return "redirect:/error500";
        }

        return "redirect:/community/pictureTeacher";

    }

    /**
    * @Description: 图文教学编辑
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-7
    */
    @RequestMapping("editPictureTeacher/{id}")
    public String editPictureTeacher(Model model, HttpSession session, @PathVariable("id")int id)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Pictureteacher pictureteacher = pictureteacherService.selectByPrimaryKey(id);

        String path = "/statics/pictureTeacher";
        String temp = pictureteacher.getPictureurl();
        String picture[] = temp.split(",");
        int length = picture.length;

        model.addAttribute("administrator", administrator);
        model.addAttribute("pictures", picture);
        model.addAttribute("pictureTeacher", pictureteacher);
        model.addAttribute("length", length);
        model.addAttribute("id", id);

        System.out.println(length);

        return "editPictureTeacher.ftl";
    }

    /**
    * @Description: 更新图文教学
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-7
    */
    @RequestMapping("updatePictureTeacher")
    public String updatePictureTeacher(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                                        @RequestParam(value = "description", defaultValue = "")String word,
                                        @RequestParam(value = "pname", defaultValue = "")String pname,
                                       @RequestParam(value = "id", defaultValue = "")int id,
                                       @RequestParam(value = "iname")String iname[])
    {
        Administrator administrator = (Administrator) session.getAttribute("user");


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        System.out.println(iname[0]);


        if(multipartFile.length >= 1)
        {

            //            System.out.println("111111111111111111");
            Pictureteacher pictureteacher = new Pictureteacher();

            //将图片上传到服务器
            String fileName = "";
            for(int i=0; i<multipartFile.length; i++)
            {
                if(multipartFile[i].isEmpty())
                {
                    continue;
                }

                fileName = fileName + ","  + multipartFile[i].getOriginalFilename();

                System.out.println(fileName);

                try
                {
                    String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/pictureTeacher";

                    File dir = new File(rootPath + File.separator);

                    if(!dir.exists())
                    {
                        dir.mkdirs();

                    }

                    File serverFile = new File(dir.getAbsolutePath() + File.separator  + multipartFile[i].getOriginalFilename());


                    multipartFile[i].transferTo(serverFile);

                    System.out.println("You successfully uploaded file=" +  multipartFile[i].getOriginalFilename());


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //将上传文件的信息插入数据库
            if(word.equals(""))
            {
                word = "NULL";
            }

            Pictureteacher temp = pictureteacherService.selectByPrimaryKey(id);
            String pictureUrl = temp.getPictureurl();
            String pi[] = pictureUrl.split(",");

            fileName = fileName.substring(1);
            String []temp1 = fileName.split(",");

            String []arr;
            if(temp1.length+iname.length > pi.length)
            {
                arr = new String[(temp1.length+iname.length)];
            }
            else
            {
                arr = new String[pi.length];
            }


            int k=0,i=0,j=0;
            for( ;i<pi.length; i++)
            {
                System.out.println(pi[i]);
//                if(i > temp1.length && i > iname.length)
//                {
//                    break;
//                }

                if(pi[i].equals(iname[j]))
                {
                    System.out.println(iname[j]);
                    arr[i] = pi[i];
                    j++;
                }
                else
                {
                    arr[i] = temp1[k];
                    k++;
                }
            }
            if(k < temp1.length)
            {
                for(; k<temp1.length; k++)
                {
                    arr[i++] = temp1[k];
                }
            }

            pictureUrl = Arrays.toString(arr);
            pictureUrl = pictureUrl.substring(1, pictureUrl.length()-1);
            pictureUrl = pictureUrl.replace(" ","");
            System.out.println(pictureUrl);

            pictureteacher.setId(id);
            pictureteacher.setWorld(word);
            pictureteacher.setPname(pname);
            pictureteacher.setPictureurl(pictureUrl);
            pictureteacher.setUpdater(administrator.getUsername());
            pictureteacher.setUpdatetime(currentDate);
            if(pictureteacherService.updateByPrimaryKeySelective(pictureteacher) == 0)
            {
                return "redirect:/error500";
            }

        }

        model.addAttribute("administrator", administrator);

        return ("redirect:/community/editPictureTeacher/"+String.valueOf(id));
    }
    /**
    * @Description: 查看图片是否已存入服务器
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-7
    */
//    private boolean exists(String name, int id)
//    {
//        Pictureteacher pictureteacher = pictureteacherService.selectByPrimaryKey(id);
//        String temp = pictureteacher.getPictureurl();
//    }



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
    public String uploadFile(@RequestParam(value = "startTime", defaultValue = "1970-01-01")String startTime, Model model, HttpSession session,
                             @RequestParam(value = "endTime", defaultValue = "1970-01-01")String endTime, @RequestParam(value = "fileName", defaultValue = "")String fileName,
                             @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "1")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);

        if(startTime.equals("1970-01-01") && endTime.equals("1970-01-01")&&fileName.equals(""))
        {
            List<Uploadfile> uploadfileList = uploadfileService.queryAll();
            PageInfo<Student> pageInfo = new PageInfo(uploadfileList);
            model.addAttribute("uploadfileList", pageInfo);

        }
        else
        {
            List<Uploadfile> uploadfileList = uploadfileService.fuzzyQuery(fileName, startTime, endTime);
            PageInfo<Student> pageInfo = new PageInfo(uploadfileList);
            model.addAttribute("uploadfileList", pageInfo);
        }


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
    public String uploadFileAchieve(@RequestParam("file")MultipartFile multipartFile, Model model, HttpSession session,
                                    @RequestParam("description")String description)
    {
//        System.out.println(multipartFile + "123");
        Uploadfile uploadfile = new Uploadfile();

        Administrator administrator = (Administrator) session.getAttribute("user");


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
                if(description.equals(""))
                {
                    description = "NULL";
                }
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
                String currentDate = simpleDateFormat.format(date);
                uploadfile.setFilename(multipartFile.getOriginalFilename());
                uploadfile.setFilesize((int)multipartFile.getSize());
                uploadfile.setFileurl(rootPath);
                uploadfile.setIsDelete(0);
                uploadfile.setAuthor(administrator.getUsername());
                uploadfile.setUploadtime(currentDate);
                uploadfile.setDescription(description);
                if(uploadfileService.insert(uploadfile) == 0)
                {
                    return "redirect:/error500";
                }
//                System.out.println(uploadfile);
                multipartFile.transferTo(serverFile);

//                System.out.println("You successfully uploaded file=" +  multipartFile.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        model.addAttribute("administrator", administrator);

        return "redirect:/community/uploadFile";
    }

    /**
    * @Description: 删除上传文件
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-5
    */
    @RequestMapping("deleteFile/{id}")
    public String deleteFile(@PathVariable("id")Integer id)
    {
        Uploadfile uploadfile = new Uploadfile();
        uploadfile.setIsDelete(1);
        uploadfile.setId(id);

        if(uploadfileService.updateByPrimaryKeySelective(uploadfile) == 0)
        {
            return "redirect:/error500";
        }

        return "redirect:/community/uploadFile";
    }
    
    /**
    * @Description: 上传图片
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-1
    */
    
    
}
