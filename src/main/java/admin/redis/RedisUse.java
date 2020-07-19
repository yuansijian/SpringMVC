package admin.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-06-11 16:24
 **/
public class RedisUse
{
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    public void saveLiked2Redis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().put("good", key, "1");
    }

    public void unlikeFormRedis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().put("good", key, "0");
    }

    public void deleteLikedFromRedis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().delete("good", key);
    }

    public boolean alreadyGood(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        System.out.println(key);
        System.out.println(redisTemplate.opsForHash().hasKey("good", key));
        return redisTemplate.opsForHash().hasKey("good", key);
        //        return false;
    }
}
