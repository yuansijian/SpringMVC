package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @program: SpringMVC
 * @description: 加载页面模板，分用
 * @author: Defend
 * @create: 2020-02-12 15:30
 **/
@Controller
public class PageController
{

    /**
    * @Description: 读取模板文件
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-2-12
    */

    @RequestMapping("testInit")
    public void init()
    {
        Configuration cfg = new Configuration();
        Map<String, String>root = new HashMap<String, String>();
        root.put("name", "java开发日记");
        try
        {
            cfg.setDirectoryForTemplateLoading(new File("/Spring/src/webapp/views/layout/defaultLayout.ftl"));
            Template template = cfg.getTemplate("defaultLayout");
            Writer writer = new FileWriter(new File("/Spring/src/webapp/views/helloword.html"));
            template.process(root, writer);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
