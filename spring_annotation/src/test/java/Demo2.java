import config.MainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.UserService;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class Demo2 {
    @Autowired
    @Qualifier("user")
    private User u;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    public void test1() {
        System.out.println(u);
    }

    @Test
    public void test2() {
        int num = jdbcTemplate.update("update m_user set create_time=? where id=1", LocalDateTime.now());
        System.out.println(num);
    }

    @Test
    public void test3() {
        userService.doDbWork();
    }
}
