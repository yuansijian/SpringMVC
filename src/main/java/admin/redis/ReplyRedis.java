package admin.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @program: SpringMVC
 * @description: 回复
 * @author: Defend
 * @create: 2020-06-25 10:27
 **/
public class ReplyRedis
{
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    public void saveLiked2Redis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().put("replyGood", key, "1");
    }

    public void unlikeFormRedis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().put("replyGood", key, "0");
    }

    public void deleteLikedFromRedis(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        redisTemplate.opsForHash().delete("replyGood", key);
    }

    public boolean alreadyGood(String likedUserId, String likePostId)
    {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likePostId);
        System.out.println(key);
        System.out.println(redisTemplate.opsForHash().hasKey("replyGood", key));
        return redisTemplate.opsForHash().hasKey("replyGood", key);
        //        return false;
    }
}
