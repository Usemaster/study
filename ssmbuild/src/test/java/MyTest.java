import com.study.pojo.Goods;
import com.study.service.GoodService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodService goodServiceImpl = (GoodService) context.getBean("GoodServiceImpl");
        for (Goods goods : goodServiceImpl.queryAllGood()) {
            System.out.println(goods);
        }
    }
}
