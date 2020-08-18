import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInfo;
import com.xss.config.SpringMybatis;
import com.xss.entity.Article;
import com.xss.entity.Dept;
import com.xss.entity.User;
import com.xss.entity.Userfocus;
import com.xss.mapper.*;
import com.xss.service.ArticleService;
import com.xss.service.FavoriteService;
import com.xss.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatis.class)
public class TestDemo {

    @Autowired
    DruidDataSource dataSource;

    @Autowired
    UserMapper mapper;

    @Autowired
    ArticleService service;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testMapper(){
        List<User> users = mapper.selectFocus(1);
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void testService(){
        List<Article> articles = service.selectScSArticles();
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
