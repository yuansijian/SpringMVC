package admin.controller;

import admin.generator.entity.*;
import admin.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static admin.controller.main.getDate;


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
    private BaseconfigService baseconfigService;
    @Autowired
    private UploadconfigService uploadconfigService;
    @Autowired
    private UploadfileService uploadfileService;
    @Autowired
    private PictureteacherService pictureteacherService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private Short1Service short1Service;
    @Autowired
    private CommentParentChildService commentParentChildService;
    @Autowired
    private CommentService commentService;
    /**
    * @Description: 查找数组是否有该元素
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-10
    */
    public static boolean isexist(String arr[], String a)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i].equals(a))
            {
                return true;
            }
        }

        return false;
    }

    /**
    * @Description: 去除数组为空的元素
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-10
    */
    public static String[] deleteNull(String[] strArray)
    {
        List<String> strList= Arrays.asList(strArray);

        List<String> strListNew=new ArrayList<>();

        for (int i = 0; i <strList.size(); i++)
        {

            if (strList.get(i)!=null && !strList.get(i).equals(""))
            {

                strListNew.add(strList.get(i));
            }

        }

        String[] strNewArray = strListNew.toArray(new String[strListNew.size()]);

        return   strNewArray;
    }

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


        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "videoTeacher.ftl";
    }

    /**
    * @Description: 上传视频保存
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-8
    */
    @ResponseBody
    @RequestMapping("videoTeacherAchieve")
    public int videoTeacherAchieve(@RequestParam("file")MultipartFile multipartFile, Model model, HttpSession session,
                                      @RequestParam("description")String description)
    {
//        System.out.println("11111111111");
//        System.out.println(description);
//        System.out.println(multipartFile.getOriginalFilename());

        VideoWithBLOBs video = new VideoWithBLOBs();

        Administrator administrator = (Administrator) session.getAttribute("user");

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
                String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/video";

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
                video.setAuthor(administrator.getUsername());
                video.setVname(multipartFile.getOriginalFilename());
                video.setIsDelete(0);
                video.setUpdater(administrator.getUsername());
                video.setUpdatetime(currentDate);
                video.setUploadtime(currentDate);
                video.setVsizes(String.valueOf(multipartFile.getSize()));
                video.setDescription(description);
                video.setVideourl("/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/video");

                if(videoService.insert(video) == 1)
                {
                    return 1;
//                    return "redirect:/community/videoTeacher";
                }

                //                System.out.println(uploadfile);
                multipartFile.transferTo(serverFile);



            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return 0;

//        return "redirect:/error500";
    }


    /**
    * @Description: 视频预览
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-8
    */
    @RequestMapping("videoPreview/{id}")
    public String videoPreview(Model model, HttpSession session, @PathVariable("id")int id)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        VideoWithBLOBs videoWithBLOBs = videoService.selectByPrimaryKey(id);

        model.addAttribute("administrator", administrator);
        model.addAttribute("video", videoWithBLOBs);

        return "videoPreview.ftl";
    }

    /**
    * @Description: 视频删除
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-8
    */
    @ResponseBody
    @RequestMapping("deleteVideo/{id}")
    public int deleteVideo(@PathVariable("id")int id)
    {
        VideoWithBLOBs videoWithBLOBs = new VideoWithBLOBs();
        videoWithBLOBs.setId(id);
        videoWithBLOBs.setIsDelete(1);

        return videoService.updateByPrimaryKeySelective(videoWithBLOBs);
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
                                 @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
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
    * @Description: 回复留言
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-24
    */
    @RequestMapping("reply/{parentid}/{parentname}")
    public String reply(@PathVariable("parentid")int parentid, @PathVariable("parentname")String parentname, Model model)
    {
        model.addAttribute("parentid", parentid);
        model.addAttribute("parentname", parentname);
        return "reply.ftl";
    }

    /**
     * @Description: 新增主楼下回复
     * @Param:
     * @return:
     * @Author: Defend
     * @Date: 20-3-16
     */
    @ResponseBody
    @RequestMapping("addReply")
    public int addReply(Model model, HttpSession session, CommentParentChild commentParentChild)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        commentParentChild.setCreatTime(getDate());
        commentParentChild.setFlag(0);
        commentParentChild.setIsDelete(0);
        commentParentChild.setUp(0);
        commentParentChild.setUsername(administrator.getUsername());

        return commentParentChildService.insert(commentParentChild);
    }

    /**
    * @Description: 图文教学保存
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-6
    */
    @ResponseBody
    @RequestMapping("pictureTeacherAchieve")
    public int pictureTeacherAchieve(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                                        @RequestParam(value = "description", defaultValue = "")String word,
                                        @RequestParam(value = "pname", defaultValue = "")String pname)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        if(multipartFile.length >= 1)
        {
            System.out.println("111111111111111111");


            Pictureteacher pictureteacher = new Pictureteacher();


            //将图片上传到服务器
            String fileName = "";
            for(int i=0; i<multipartFile.length; i++)
            {
                //获取文件允许上传的类型
                Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);
                String types = uploadconfig.getImageconfig();
                String []arr = types.split(",");

                //文件扩展名
                String type = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".") + 1);

                if(!isexist(arr, type))
                {
                    return 303;
                    //            return "redirect:/error500";
                }

                if(multipartFile[i].getSize() > 204800000)
                {
                    return 202;
                    //            return "redirect:/error500";
                }

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

//                    System.out.println("You successfully uploaded file=" +  multipartFile[i].getOriginalFilename());


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
            fileName = fileName.substring(1);
            pictureteacher.setPictureurl(fileName);
            pictureteacher.setIsDelete(0);
            pictureteacher.setAuthor(administrator.getUsername());
            pictureteacher.setCreatetime(currentDate);
            pictureteacher.setUpdater(administrator.getUsername());
            pictureteacher.setUpdatetime(currentDate);
            if(pictureteacherService.insert(pictureteacher) == 1)
            {
                return 1;
            }

        }

//        model.addAttribute("administrator", administrator);

        return 0;

    }

    /**
    * @Description: 图文教学删除
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-7
    */
    @ResponseBody
    @RequestMapping("deletePictureTeacher/{id}")
    public int deletePictureTeacher(@PathVariable("id")int id)
    {
        Pictureteacher pictureteacher = new Pictureteacher();
        pictureteacher.setId(id);
        pictureteacher.setIsDelete(1);

        return pictureteacherService.updateByPrimaryKeySelective(pictureteacher);


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
    @ResponseBody
    @RequestMapping("updatePictureTeacher")
    public int updatePictureTeacher(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                                        @RequestParam(value = "description", defaultValue = "")String word,
                                        @RequestParam(value = "pname", defaultValue = "")String pname,
                                       @RequestParam(value = "id", defaultValue = "")int id,
                                       @RequestParam(value = "iname")String iname[])
    {
//        System.out.println("1111111111111111111111");
//        System.out.println(multipartFile.length);
//        System.out.println(multipartFile[0].getOriginalFilename());

        Administrator administrator = (Administrator) session.getAttribute("user");


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        //获取文件允许上传的类型
        Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);
        String types = uploadconfig.getImageconfig();
        String []arr1 = types.split(",");
        String type;
        int count = 0;

        //图片新增或替换
        if(multipartFile.length >= 1)
        {

            //            System.out.println("111111111111111111");
            Pictureteacher pictureteacher = new Pictureteacher();

            //将图片上传到服务器
            String fileName = "";

            for(int i=0; i<multipartFile.length; i++)
            {
                if(multipartFile[i].getOriginalFilename().equals(""))
                {
                    count++;
                    System.out.println(1);
                    System.out.println(iname[i]);
                    continue;
                }



                //文件扩展名
                type = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".") + 1);

                if(!isexist(arr1, type))
                {
                    return 303;
                    //            return "redirect:/error500";
                }

                if(multipartFile[i].getSize() > 204800000)
                {
                    return 202;
                    //            return "redirect:/error500";
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
            String pictureUrl = temp.getPictureurl();       //以前的图片
            String pi[] = pictureUrl.split(",");

            System.out.println(12);
            String temp1[] = new String[multipartFile.length];
            if(count != multipartFile.length)
            {
                fileName = fileName.substring(1);
                System.out.println(fileName);
                temp1 = fileName.split(",");       //新增或更新的图片
            }
            String []temp2 = deleteNull(temp1);




            String []arr = new String[(temp2.length+iname.length)];       //更新要存的图片


            int k=0,i=0,j=0, h=0;
            //匹配,看以前的图片剩下多少
            for( ;i<pi.length; i++)
            {
                System.out.println(pi[i]);
                System.out.println(i);
                System.out.println(temp1[0]);


//                if(i > temp1.length && i > iname.length)
//                {
//                    break;
//                }

                //图片未更新de
                if(j< iname.length)
                {
                    if(pi[i].equals(iname[j]))
                    {
                        System.out.println(0);
                        System.out.println(iname[j]);
                        arr[h] = pi[i];
                        j++;
                        h++;
                    }
                }

                else if(k < temp2.length)
                {
                    System.out.println(1);
                    arr[h] = temp2[k];
                    h++;
                    k++;
                }
                System.out.println(3);
            }

            System.out.println(2);
            if(k < temp2.length)
            {
                for(; k<temp2.length; k++)
                {
                    arr[h++] = temp2[k];
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
            if(pictureteacherService.updateByPrimaryKeySelective(pictureteacher) == 1)
            {
                return 1;
            }

        }

//        model.addAttribute("administrator", administrator);

        return 0;
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
    public String shortAnswerDatabase(@RequestParam(value = "startTime", defaultValue = "1970-01-01")String startTime, Model model, HttpSession session,
                                      @RequestParam(value = "endTime", defaultValue = "1970-01-01")String endTime, @RequestParam(value = "keyword", defaultValue = "")String keyword,
                                      @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        if(startTime.equals("1970-01-01") && endTime.equals("1970-01-01")&&keyword.equals(""))
        {
            List<Short1WithBLOBs> list = short1Service.queryAll();
            PageInfo<Short1WithBLOBs> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);

        }
        else
        {
            List<Short1WithBLOBs> list = short1Service.fuzzyQuery(startTime, endTime, keyword);
            PageInfo<Short1WithBLOBs> pageInfo = new PageInfo(list);
            model.addAttribute("pageInfo", pageInfo);
        }

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "shortAnswerDatabase.ftl";
    }

    /**
    * @Description: 简答题库删除
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-19
    */
    @ResponseBody
    @RequestMapping("deleteShort/{id}")
    public int deleteShort(@PathVariable("id")int id)
    {
        Short1WithBLOBs shortWithBLOBs = new Short1WithBLOBs();

        shortWithBLOBs.setId(id);
        shortWithBLOBs.setIsDelete(1);

        return short1Service.updateByPrimaryKeySelective(shortWithBLOBs);
    }
    
    /**
    * @Description: 编辑简答题
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-19
    */
    @RequestMapping("editShort/{id}")
    public String editShort(Model model, HttpSession session, @PathVariable("id")int id)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Short1WithBLOBs shortWithBLOBs = short1Service.selectByPrimaryKey(id);
//        Pictureteacher pictureteacher = pictureteacherService.selectByPrimaryKey(id);

        String path = "/statics/short";
        String temp = shortWithBLOBs.getImageurl();
        String picture[] = temp.split(",");
        int length = picture.length;

        model.addAttribute("administrator", administrator);
        model.addAttribute("pictures", picture);
        model.addAttribute("shortWithBLOBs", shortWithBLOBs);
        model.addAttribute("length", length);
        model.addAttribute("id", id);

        System.out.println(length);

        return "editShort.ftl";
    }

    /**
    * @Description: 更新简答题
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-19
    */
    @ResponseBody
    @RequestMapping("updateShort")
    public int updateShort(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                           @RequestParam(value = "content", defaultValue = "")String content,
                           @RequestParam(value = "title", defaultValue = "")String title,
                           @RequestParam(value = "id", defaultValue = "")int id,
                           @RequestParam(value = "answer", defaultValue = "")String answer,
                           @RequestParam(value = "iname")String iname[])
    {
        //        System.out.println("1111111111111111111111");
        //        System.out.println(multipartFile.length);
        //        System.out.println(multipartFile[0].getOriginalFilename());

        Administrator administrator = (Administrator) session.getAttribute("user");


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        //获取文件允许上传的类型
        Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);
        String types = uploadconfig.getImageconfig();
        String []arr1 = types.split(",");
        String type;
        int count = 0;

        //图片新增或替换
        if(multipartFile.length >= 1)
        {

            //            System.out.println("111111111111111111");
//            Pictureteacher pictureteacher = new Pictureteacher();
            Short1WithBLOBs shortWithBLOBs = new Short1WithBLOBs();

            //将图片上传到服务器
            String fileName = "";

            for(int i=0; i<multipartFile.length; i++)
            {
                if(multipartFile[i].getOriginalFilename().equals(""))
                {
                    count++;
                    System.out.println(1);
                    System.out.println(iname[i]);
                    continue;
                }



                //文件扩展名
                type = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".") + 1);

                if(!isexist(arr1, type))
                {
                    return 303;
                    //            return "redirect:/error500";
                }

                if(multipartFile[i].getSize() > 204800000)
                {
                    return 202;
                    //            return "redirect:/error500";
                }

                fileName = fileName + ","  + multipartFile[i].getOriginalFilename();

                System.out.println(fileName);

                try
                {
                    String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/short";

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
            if(content.equals(""))
            {
                content = "NULL";
            }

            Short1WithBLOBs temp = short1Service.selectByPrimaryKey(id);
            String pictureUrl = temp.getImageurl();       //以前的图片
            String pi[] = pictureUrl.split(",");

            System.out.println("11111111111111");
            System.out.println(pi[0]);

            System.out.println(pi.length);

            System.out.println(12);

            String temp1[] = new String[multipartFile.length];
            if(count != multipartFile.length)
            {
                fileName = fileName.substring(1);
                System.out.println(fileName);
                temp1 = fileName.split(",");       //新增或更新的图片
            }
            String []temp2 = deleteNull(temp1);




            String []arr = new String[(temp2.length+iname.length)];       //更新要存的图片


            int k=0,i=0,j=0, h=0;
            //匹配,看以前的图片剩下多少
            for( ;i<pi.length; i++)
            {



                //                if(i > temp1.length && i > iname.length)
                //                {
                //                    break;
                //                }

                //图片未更新de
                if(j< iname.length)
                {
                    if(pi[i].equals(iname[j]))
                    {
                        System.out.println(0);
                        System.out.println(iname[j]);
                        arr[h] = pi[i];
                        j++;
                        h++;
                    }
                }

                else if(k < temp2.length)
                {
                    System.out.println(1);
                    arr[h] = temp2[k];
                    h++;
                    k++;
                }
                System.out.println(3);
            }

            System.out.println(2);
            if(k < temp2.length)
            {
                for(; k<temp2.length; k++)
                {
                    arr[h++] = temp2[k];
                }
            }

            pictureUrl = Arrays.toString(arr);
            pictureUrl = pictureUrl.substring(1, pictureUrl.length()-1);
            pictureUrl = pictureUrl.replace(" ","");
            System.out.println(pictureUrl);

            shortWithBLOBs.setId(id);
            shortWithBLOBs.setContent(content);
            shortWithBLOBs.setTitle(title);
            shortWithBLOBs.setImageurl(pictureUrl);
            shortWithBLOBs.setUpdater(administrator.getUsername());
            shortWithBLOBs.setUpdatetime(currentDate);
            shortWithBLOBs.setAnswer(answer);
            if(short1Service.updateByPrimaryKeySelective(shortWithBLOBs) == 1)
            {
                return 1;
            }

        }

        //        model.addAttribute("administrator", administrator);

        return 0;
    }
    
    /**
    * @Description: 新增简答题
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-19
    */
    @RequestMapping("addShort")
    public String addShort(Model model, HttpSession session)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);

        return "addShort.ftl";
    }
    /**
    * @Description: 新增简答题保存
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-19
    */
    @ResponseBody
    @RequestMapping("shortAchieve")
    public int shortAchieve(Model model, HttpSession session, @RequestParam(value = "image")MultipartFile []multipartFile,
                            @RequestParam(value = "content", defaultValue = "")String content,
                            @RequestParam(value = "title", defaultValue = "")String title,
                            @RequestParam(value = "answer", defaultValue = "")String answer)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        if(multipartFile.length >= 1)
        {
            System.out.println("111111111111111111");


            Short1WithBLOBs shortWithBLOBs = new Short1WithBLOBs();
//            Pictureteacher pictureteacher = new Pictureteacher();


            //将图片上传到服务器
            String fileName = "";
            for(int i=0; i<multipartFile.length; i++)
            {
                //获取文件允许上传的类型
                Uploadconfig uploadconfig = uploadconfigService.selectByPrimaryKey(1);
                String types = uploadconfig.getImageconfig();
                String []arr = types.split(",");

                //文件扩展名
                String type = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".") + 1);

                if(!isexist(arr, type))
                {
                    return 303;
                    //            return "redirect:/error500";
                }

                if(multipartFile[i].getSize() > 204800000)
                {
                    return 202;
                    //            return "redirect:/error500";
                }

                fileName = fileName + "," + multipartFile[i].getOriginalFilename();
                try
                {
                    String rootPath = "/home/protecting/Documents/javaProject/SpringMVC/src/main/webapp/statics/short";

                    File dir = new File(rootPath + File.separator);

                    if(!dir.exists())
                    {
                        dir.mkdirs();
                    }

                    File serverFile = new File(dir.getAbsolutePath() + File.separator + (multipartFile[i].getOriginalFilename()));


                    multipartFile[i].transferTo(serverFile);

                    //                    System.out.println("You successfully uploaded file=" +  multipartFile[i].getOriginalFilename());


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //将上传文件的信息插入数据库
            if(content.equals(""))
            {
                content = "NULL";
            }

            shortWithBLOBs.setContent(content);
            shortWithBLOBs.setTitle(title);
            fileName = fileName.substring(1);
            shortWithBLOBs.setImageurl(fileName);
            shortWithBLOBs.setIsDelete(0);
            shortWithBLOBs.setQuestioner(administrator.getUsername());
            shortWithBLOBs.setCreatetime(currentDate);
            shortWithBLOBs.setUpdater(administrator.getUsername());
            shortWithBLOBs.setUpdatetime(currentDate);
            shortWithBLOBs.setAnswer(answer);
            if(short1Service.insert(shortWithBLOBs) == 1)
            {
                return 1;
            }

        }

        //        model.addAttribute("administrator", administrator);

        return 0;

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
        BaseconfigWithBLOBs baseconfig = baseconfigService.selectByPrimaryKey(1);

        Administrator administrator = (Administrator) session.getAttribute("user");
        model.addAttribute("administrator", administrator);
        model.addAttribute("system", baseconfig);

        return "baseConfig.ftl";
    }

    /**
    * @Description: 更新基本配置
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-10
    */
    @ResponseBody
    @RequestMapping("updateConfig/{id}")
    public int updateConfig(@RequestParam(value = "logopic")String logopic, HttpSession session,
                            @RequestParam(value = "keyword")String keyword, @RequestParam(value = "description")String description,
                            @RequestParam(value = "copyright")String copyright, @RequestParam(value = "record")String record,
                            @RequestParam(value = "switch1")String switch1, @PathVariable("id")int id)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        BaseconfigWithBLOBs baseconfigWithBLOBs = new BaseconfigWithBLOBs();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String currentDate = simpleDateFormat.format(date);     //当前时间

        baseconfigWithBLOBs.setUpdater(administrator.getUsername());
        baseconfigWithBLOBs.setUpdatetime(currentDate);
        baseconfigWithBLOBs.setId(id);
        baseconfigWithBLOBs.setCopyright(copyright);
        baseconfigWithBLOBs.setDescription(description);
        baseconfigWithBLOBs.setLogopic(logopic);
        baseconfigWithBLOBs.setKeyword(keyword);
        baseconfigWithBLOBs.setSwitch1(Integer.parseInt(switch1));
        baseconfigWithBLOBs.setRecord(record);

        System.out.println(baseconfigWithBLOBs.getSwitch1());

        return baseconfigService.updateByPrimaryKeySelective(baseconfigWithBLOBs);
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
    @ResponseBody
    @RequestMapping("uploadUpdate")
    public int uploadUpdate(Uploadconfig uploadconfig, Model model, HttpSession session)
    {
        uploadconfig.setId(1);

        return uploadconfigService.updateByPrimaryKeySelective(uploadconfig);
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
                             @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
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
    @ResponseBody
    @RequestMapping("uploadFileAchieve")
    public int uploadFileAchieve(@RequestParam("file")MultipartFile multipartFile, Model model, HttpSession session,
                                    @RequestParam("description")String description)
    {
//        System.out.println(multipartFile + "123");
        Uploadfile uploadfile = new Uploadfile();

        Administrator administrator = (Administrator) session.getAttribute("user");

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
                if(uploadfileService.insert(uploadfile) == 1)
                {
                    return 1;
                }
//                System.out.println(uploadfile);
                multipartFile.transferTo(serverFile);

//                System.out.println("You successfully uploaded file=" +  multipartFile.getOriginalFilename());


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        model.addAttribute("administrator", administrator);

        return 0;
    }

    /**
    * @Description: 删除上传文件
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-5
    */
    @ResponseBody
    @RequestMapping("deleteFile/{id}")
    public int deleteFile(@PathVariable("id")Integer id)
    {
        Uploadfile uploadfile = new Uploadfile();
        uploadfile.setIsDelete(1);
        uploadfile.setId(id);

        return uploadfileService.updateByPrimaryKeySelective(uploadfile);
    }

    /**
    * @Description: 留言管理
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-3-23
    */
    @RequestMapping("manageMessage")
    public String manageMessage(HttpSession session, Model model,
                                @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
    {
        Administrator administrator = (Administrator) session.getAttribute("user");

        Student student = (Student)session.getAttribute("student");
        PageHelper.startPage(pageNum, pageSize);
        List<CommentWithBLOBs> comment = commentService.queryAll();
        PageInfo<CommentWithBLOBs> pageInfo = new PageInfo(comment);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("student", student);
        model.addAttribute("administrator", administrator);

        return "manageMessage.ftl";
    }
    /**
     * @Description: 删除留言
     * @Param:
     * @return:
     * @Author: Defend
     * @Date: 20-3-23
     */
    @ResponseBody
    @RequestMapping("deleteMessage/{id}")
    public int deleteMessage(@PathVariable("id")int id)
    {
        CommentWithBLOBs comment = new CommentWithBLOBs();
        comment.setId(id);
        comment.setIsDelete(1);
        comment.setDeleteTime(getDate());

        return commentService.updateByPrimaryKeySelective(comment);
    }

    /**
    * @Description: 留言回复
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-23
    */
    @RequestMapping("manageReply")
    public String manageReply(HttpSession session, Model model,
                              @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10")int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        Administrator administrator = (Administrator) session.getAttribute("user");


        List<CommentParentChild> reply = commentParentChildService.queryAll();
        PageInfo<CommentParentChild> pageInfo = new PageInfo(reply);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("administrator", administrator);

        return "manageReply.ftl";
    }

    /**
    * @Description: 删除
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-3-23
    */
    @ResponseBody
    @RequestMapping("deleteReply/{id}")
    public int deleteReply(@PathVariable("id")int id)
    {
        CommentParentChild commentParentChild = new CommentParentChild();

        commentParentChild.setIsDelete(1);
        commentParentChild.setDeleteTime(getDate());
        commentParentChild.setId(id);

        return commentParentChildService.updateByPrimaryKeySelective(commentParentChild);
    }


}
