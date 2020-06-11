//package admin.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import redis.clients.jedis.JedisPool;
//
///**
// * @program: SpringMVC
// * @description: redisdao层
// * @author: Defend
// * @create: 2020-06-04 16:06
// **/
//@Repository
//public class RedisDao
//{
//    @Autowired
//    private JedisPool jedisPool;
//
//    public String get(String key)
//    {
//        return jedisPool.getResource().get(key)
//    }
//
//    public String set(String key, String value)
//    {
//        return jedisPool.getResource().set(key, value);
//    }
//}
