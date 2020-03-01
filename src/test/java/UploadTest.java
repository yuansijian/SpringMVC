import admin.generator.dao.UploadconfigMapper;
import admin.generator.entity.Uploadconfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: SpringMVC
 * @description:
 * @author: Defend
 * @create: 2020-02-29 17:52
 **/
public class UploadTest extends BaseTest
{
    @Autowired
    UploadconfigMapper uploadconfigMapper;

    @Test
    public void testUpload() throws Exception
    {
        Uploadconfig uploadconfig = new Uploadconfig();
        uploadconfig.setId(1);
        uploadconfig.setImage(5000);
        uploadconfig.setImageconfig("s");
        uploadconfig.setLimit1(0);
        uploadconfig.setImageconfig("s");

        uploadconfigMapper.updateByPrimaryKeySelective(uploadconfig);
    }
}
