import admin.generator.dao.AdministratorMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Yuan Sijian
 * @create: 2020-02-29 22:06
 **/
public class testLogin extends BaseTest
{
    @Autowired
    AdministratorMapper administratorMapper;

    @Test
    public void testQuery() throws Exception
    {
        System.out.println(administratorMapper.queryByUsernameAndPassword("yuan", "0000"));
    }
}
