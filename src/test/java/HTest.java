import MyThesis.utils.CrawUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HTest {

//    @Autowired
//    private RedisCacheUtil redisCacheUtil;
    @Autowired
    private CrawUtil crawUtil;


    @Test
    public void test(){
//        redisCacheUtil.set("1", "111");
//        System.out.println(redisCacheUtil.get("1"));
        crawUtil.getContent();
    }
}
