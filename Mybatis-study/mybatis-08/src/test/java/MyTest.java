import com.study.dao.BlogMapper;
import com.study.pojo.Blog;
import com.study.utils.IDUtils;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public  void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("views",9999);
        map.put("title","Java如此简单");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

//        List<Blog> blogs = mapper.queryBlogChoose(map);
//
//        System.out.println(blogs);

        sqlSession.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","9d6a763f5e1347cebda43e2a32687a77");

        mapper.updateBlog(map);


        session.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }
}
