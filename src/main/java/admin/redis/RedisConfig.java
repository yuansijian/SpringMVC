package admin.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @program: SpringMVC
 * @description: 配置
 * @author: Defend
 * @create: 2020-06-04 15:43
 **/
@Configuration
public class RedisConfig
{
    @Bean
    public JedisConnectionFactory redisConnectionFactory()
    {
        return new JedisConnectionFactory();
    }
}
