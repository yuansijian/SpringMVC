import admin.generator.dao.StudentMapper;
import admin.generator.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-02-22 18:01
 **/
public class StudentTest extends BaseTest
{
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testQueryAll() throws Exception
    {
        System.out.println(studentMapper.queryAll());
    }

    @Test
    public void testFuzzySerach() throws Exception
    {
        String test = null;
        System.out.println(studentMapper.fuzzySearch("test"));
    }
}
