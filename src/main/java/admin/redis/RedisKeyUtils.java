package admin.redis;

/**
 * @program: SpringMVC
 * @description: 用于根据一定规则生成key
 * @author: Defend
 * @create: 2020-06-11 14:26
 **/
public class RedisKeyUtils
{
    //保存留言点赞的key
    public static final String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";
    //保存留言被点赞的key
    public static final String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";

    /**
     * @Description: 拼接点赞用户id和留言id作为key，格式222::333
     * @Param:
     * @return:
     * @Author: Defend
     * @Date: 20-6-11
     */
    public static String getLikedKey(String likedUserId, String likedPostId)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(likedUserId);
        builder.append("::");
        builder.append(likedPostId);

        return builder.toString();
    }
}
