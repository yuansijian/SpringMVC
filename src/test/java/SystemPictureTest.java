import admin.generator.dao.SystempictureMapper;
import admin.generator.entity.Systempicture;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-02-25 22:54
 **/
public class SystemPictureTest extends BaseTest
{
    @Autowired
    SystempictureMapper systempictureMapper;

    @Test
    public void testSystempicture() throws Exception
    {
        System.out.println(systempictureMapper.selectByPrimaryKey(1));
    }

}
