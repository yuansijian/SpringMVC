package admin.controller;

import admin.generator.entity.Commentgood;
import admin.generator.entity.Replygood;
import admin.service.CommentgoodService;
import admin.service.ReplygoodService;
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
    @Autowired
    private ReplygoodService replygoodService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron = "0/30 * * * * ? ") //间隔5秒执行
    public void FlightTrainTask()
    {
        if (redisTemplate.opsForHash().size("good") > 0)
        {
            String s1 = redisTemplate.opsForHash().keys("good").toString();
            s1 = s1.replace("[", "");
            s1 = s1.replace("]", "");
            s1 = s1.replace(" ", "");

            String[] list1 = s1.split(",");


            String id1 = "";
            String uid1 = "";
            String good1 = "";
            String[] temp1 = new String[2];
            int kid1 = 0;

            Commentgood commentgood = new Commentgood();


            for (String s : list1)
            {
                //                System.out.println(s);
                good1 = redisTemplate.opsForHash().get("good", s).toString();
                temp1 = s.split("::");
                uid1 = temp1[0];
                id1 = temp1[1];

                Commentgood tempCom = commentgoodService.presence(Integer.parseInt(uid1), Integer.parseInt(id1));

                commentgood.setCid(Integer.parseInt(id1));
                commentgood.setIsDelete(0);
                commentgood.setUid(Integer.parseInt(uid1));
                commentgood.setUp(Integer.parseInt(good1));

                if (tempCom != null)
                {
                    commentgood.setId(tempCom.getId());
                    commentgoodService.updateByPrimaryKeySelective(commentgood);
                } else
                {
                    commentgoodService.insertSelective(commentgood);
                }
            }

            for (String s : list1)
            {
                System.out.println(s);
                redisTemplate.opsForHash().delete("good", s);
            }
        }


        if (redisTemplate.opsForHash().size("replyGood") > 0)
        {
            String s2 = redisTemplate.opsForHash().keys("replyGood").toString();
            s2 = s2.replace("[", "");
            s2 = s2.replace("]", "");
            s2 = s2.replace(" ", "");

            System.out.println(s2);

            String[] list2 = s2.split(",");


            String id2 = "";
            String uid2 = "";
            String good2 = "";
            String[] temp2 = new String[2];
            int kid2 = 0;

            Replygood replygood = new Replygood();

            //            Commentgood commentgood = new Commentgood();


            for (String s : list2)
            {
                System.out.println(s);
                good2 = redisTemplate.opsForHash().get("replyGood", s).toString();
                temp2 = s.split("::");
                uid2 = temp2[0];
                id2 = temp2[1];

                Replygood tempCom = replygoodService.existId(Integer.parseInt(uid2), Integer.parseInt(id2));

                replygood.setCid(Integer.parseInt(id2));
                replygood.setIsDelete(0);
                replygood.setUid(Integer.parseInt(uid2));
                replygood.setUp(Integer.parseInt(good2));

                if (tempCom != null)
                {
                    replygood.setId(tempCom.getId());
                    replygoodService.updateByPrimaryKeySelective(replygood);
                } else
                {
                    replygoodService.insert(replygood);
                }
            }

            for (String s : list2)
            {
                System.out.println(s);
                redisTemplate.opsForHash().delete("good", s);
            }
        }

        //        redisTemplate.opsForHash().;
        System.out.println("定时任务-----------------------------");

    }


}
