package admin.service.impl;

import admin.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @program: SpringMVC
 * @description: redis借口实现
 * @author: Defend
 * @create: 2020-06-11 13:56
 **/
public class RedisServiceImpl implements RedisService
{
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void saveLiked2Redis(String likedUserId, String likePostId)
    {
        String key = likedUserId + "::" + likePostId;
        redisTemplate.opsForHash().put("good", key, "1");
    }

    @Override
    public void unlikeFormRedis(String likedUserId, String likePostId)
    {
        String key = likedUserId + "::" + likePostId;
        redisTemplate.opsForHash().put("good", key, "0");
    }

    @Override
    public void deleteLikedFromRedis(String likedUserId, String likedPostId)
    {
        String key = likedUserId + "::" + likedPostId;
        redisTemplate.opsForHash().delete("good", key);
    }

    @Override
    public int addGood(int id)
    {
        return 0;
    }

    @Override
    public int decreaseGood(int id)
    {
        return 0;
    }
}
