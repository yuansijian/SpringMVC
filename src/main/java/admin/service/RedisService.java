package admin.service;

public interface RedisService
{
    /**
    * @Description: 点赞，状态为1
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-11
    */
    void saveLiked2Redis(String likerdUerId, String likePostId);

    /**
    * @Description: 取消点赞，将状态改为0
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-11
    */
    void unlikeFormRedis(String likerdUerId, String likePosted);

    /**
    * @Description: 从redis中删除一条点赞数据
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-11
    */
    void deleteLikedFromRedis(String likedUserId, String likedPostId);

    /**
    * @Description: 该留言点赞数加1
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-11
    */
    int addGood(int id);

    /**
    * @Description: 该留言的点赞数减一
    * @Param:
    * @return:
    * @Author: Defend
    * @Date: 20-6-11
    */
    int decreaseGood(int id);
    
    /**
    * @Description: 获取Redis中存储的所有点赞数据
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-6-11
    */
    
    /**
    * @Description: 获取Redis中存储的所有点赞数量
    * @Param: 
    * @return: 
    * @Author: Defend
    * @Date: 20-6-11
    */

}
