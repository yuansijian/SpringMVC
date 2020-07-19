import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @program: SpringMVC
 * @description: redis测试
 * @author: Defend
 * @create: 2020-06-04 15:26
 **/
public class RedisTest extends BaseTest
{
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void redisTest()
    {
        System.out.println(redisTemplate.opsForHash().keys("replyGood"));
    }
}
