import com.study.dao.UserMapper;
import com.study.pojo.User;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);


        sqlSession.clearCache();//手动清除缓存

        System.out.println("================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        sqlSession.close();
    }

    @Test
    public void testQueryUserById(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        HashMap map = new HashMap();
        map.put("name","kuangshen");
        map.put("id",4);
        mapper.updateUser(map);

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }
}
