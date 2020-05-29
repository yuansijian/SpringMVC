import admin.generator.dao.LoginnumberMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-05-25 17:16
 **/
public class AllTest extends  BaseTest
{
    @Autowired
    LoginnumberMapper loginnumberMapper;

    @Test
    public void numtest() throws Exception
    {
        System.out.println(loginnumberMapper.selectByPrimaryKey(1));
    }
}
