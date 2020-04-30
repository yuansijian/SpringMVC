import admin.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Yuan Sijian
 * @create: 2020-02-19 21:13
 **/
public class UserServiceImplTest extends BaseTest
{
    @Autowired
    private UserService userService;


    @Test
    public void testUser() throws Exception
    {
        int uid = 1;
        System.out.println(userService.selectByPrimaryKey(1));
    }
}
