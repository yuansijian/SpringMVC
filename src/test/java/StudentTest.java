import admin.generator.dao.StudentMapper;
import admin.generator.entity.Student;
import admin.generator.entity.Systempicture;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: SpringMVC
 * @description:
 * @author: Yuan Sijian
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
//        System.out.println(studentMapper.queryFuzzyRegistered("袁思健","", "1970-01-01", "1970-01-01"));
    }
    @Test
    public void page() throws Exception
    {
        PageHelper.startPage(2, 1);

        List<Student> studentList = studentMapper.queryAll();
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);

        for(Student item : studentList) {
            System.out.println(item);
        }

        long total = pageInfo.getTotal(); //获取总记录数
        System.out.println("共有商品信息：" + total);
    }

    @Test
    public void testDate() throws Exception
    {
        System.out.println(studentMapper.queryRes("2020-02-23", "2020-02-29"));
    }

    @Test
    public void queryByname() throws Exception
    {
        System.out.println(studentMapper.queryByName("test"));
    }
}
