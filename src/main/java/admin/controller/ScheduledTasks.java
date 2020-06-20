package admin.controller;

import admin.generator.entity.Commentgood;
import admin.service.CommentgoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: SpringMVC
 * @description: 定时任务
 * @author: Defend
 * @create: 2020-06-19 15:25
 **/
@Component
public class ScheduledTasks
{
    @Autowired
    private CommentgoodService commentgoodService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron="0/30 * * * * ? ") //间隔5秒执行
    public void FlightTrainTask()
    {
        String s1 = redisTemplate.opsForHash().keys("good").toString();
        s1 = s1.replace("[", "");
        s1 = s1.replace("]", "");
        s1 = s1.replace(" ", "");

        String []list = s1.split(",");

        String id="";
        String uid = "";
        String good = "";
        String[] temp = new String[2];
        int kid = 0;

        Commentgood commentgood = new Commentgood();


        for(String s : list)
        {
            System.out.println(s);
            good = redisTemplate.opsForHash().get("good", s).toString();
            temp = s.split("::");
            uid = temp[0];
            id  = temp[1];

            Commentgood tempCom = commentgoodService.presence(Integer.parseInt(uid), Integer.parseInt(id));

            commentgood.setCid(Integer.parseInt(id));
            commentgood.setIsDelete(0);
            commentgood.setUid(Integer.parseInt(uid));
            commentgood.setUp(Integer.parseInt(good));

            if(tempCom != null)
            {
                commentgood.setId(tempCom.getId());
                commentgoodService.updateByPrimaryKeySelective(commentgood);
            }
            else
            {
                commentgoodService.insertSelective(commentgood);
            }

            System.out.println("定时任务-----------------------------");
        }

    }

}
