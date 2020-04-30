import admin.generator.dao.UserMapper;
import admin.generator.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Yuan Sijian
 * @create: 2020-02-19 17:05
 **/
public class UserTest extends BaseTest
{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryById() throws Exception {
        int uid = 1;
        User user = userMapper.selectByPrimaryKey(uid);
        System.out.println(user);
    }

}
