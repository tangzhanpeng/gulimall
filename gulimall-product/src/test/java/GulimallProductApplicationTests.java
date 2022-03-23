
import com.alibaba.druid.support.json.JSONUtils;
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.OSSClientBuilder;
//import com.aliyun.oss.model.GetObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tzp.gulimall.product.GulimallProductApplication;
import com.tzp.gulimall.product.entity.BrandEntity;
import com.tzp.gulimall.product.service.BrandService;
import com.tzp.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * 1、引入oss-starter
 * 2、配置key，endpoint相关信息即可
 * 3、使用OSSClient 进行相关操作
 */
@Slf4j
@SpringBootTest(classes = GulimallProductApplication.class)
public class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;
//    @Autowired
//    private OSSClient ossClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedissonClient redissonClient;

//    @Test
//    public void testFindPath(){
//        Long[] catelogPath = categoryService.findCatelogPath(225L);
//        log.info("完整路径：{}",Arrays.asList(catelogPath));
//    }


    @Test
    public void contextLoads() {

        //BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("华为");
//        brandService.save(brandEntity);
//        log.info("测试成功");

//
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功....");

//        brandService.updateById(brandEntity);


        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        for (BrandEntity item : list) {
            System.out.println(item);
        }

    }

    @Test
    public void uploadTest() throws FileNotFoundException {
//        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
//        String endpoint = "oss-cn-hangzhou.aliyuncs.com";
//// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tQjPCnKXS4izHriTSD7";
//        String accessKeySecret = "j8I0KFUu2Pv4lnP34szVH77a3HbKDt";
// 填写Bucket名称，例如examplebucket。
//        String bucketName = "gulimall-tzp";
////
//// 填写文件名。文件名包含路径，不包含Bucket名称。例如exampledir/exampleobject.txt。
//        String objectName = "test/5.jpg";
//
//// 创建OSSClient实例。
//        InputStream inputStream = new FileInputStream("/Users/tangzhanpeng/Desktop/WechatIMG14.jpeg");
//        ossClient.putObject(bucketName, objectName, inputStream);

// 关闭OSSClient。
//        ossClient.shutdown();
    }

    @Test
    public void redisTest() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("hello,","world" + UUID.randomUUID());

        BoundValueOperations<String, String> hello = stringRedisTemplate.boundValueOps("hello");
        System.out.println(hello.get());
    }

    @Test
    public void redissonTest() {
        System.out.println(redissonClient);
    }

}
