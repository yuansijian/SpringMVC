import admin.generator.dao.TeacherMapper;
import admin.generator.entity.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-02-25 14:16
 **/
public class TeacherTest extends BaseTest
{
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void testQueryAll() throws Exception
    {
//        System.out.println(teacherMapper.queryAll());
        System.out.println(teacherMapper.queryFuzzyRegistered("t", "1970-01-01", "1970-01-01"));
    }

}
