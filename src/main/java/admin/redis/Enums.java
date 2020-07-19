package admin.redis;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @program: SpringMVC
 * @description: 用户点赞美剧类
 * @author: Defend
 * @create: 2020-06-11 14:35
 **/
public class Enums
{
    public enum LikedStatusEnum
    {
        LIKE(1, "点赞"), UNLIKE(0, "取消点赞/未点赞"),
        ;

        private Integer code;

        private String msg;

        LikedStatusEnum(Integer code, String msg)
        {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode()
        {
            return this.code;
        }
    }
}
