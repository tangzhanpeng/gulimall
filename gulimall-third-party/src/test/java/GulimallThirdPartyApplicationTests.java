import com.aliyun.oss.OSSClient;
import com.tzp.gulimall.thirdparty.GulimallThirdPartyApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest(classes = GulimallThirdPartyApplication.class)
class GulimallThirdPartyApplicationTests {

    @Autowired
    OSSClient ossClient;

    @Test
    public void testUpload() throws FileNotFoundException {

        // 上传文件流。
        InputStream inputStream = new FileInputStream("/Users/tangzhanpeng/Desktop/WechatIMG14.jpeg");

        ossClient.putObject("gulimall-tzp", "test/9.jpg", inputStream);

//        // 关闭OSSClient。
//        ossClient.shutdown();

        System.out.println("上传完成...");
    }
}
