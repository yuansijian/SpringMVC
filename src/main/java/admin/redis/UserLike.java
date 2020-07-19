package admin.redis;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-06-11 14:48
 **/
public class UserLike
{
    private Integer id;

    //点赞的用户id
    private String likedUserId;

    //被点赞留言Id
    private String likedPostId;

    private Integer status = Enums.LikedStatusEnum.UNLIKE.getCode();

    public UserLike()
    {
    }

    public UserLike(String likedUserId, String likedPostId, Integer status)
    {
        this.likedPostId = likedPostId;
        this.likedUserId = likedUserId;
        this.status = status;
    }
}
