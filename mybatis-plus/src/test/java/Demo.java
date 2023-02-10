import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Lang;
import pojo.User;
import service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Demo {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User u = new User();
        u.setName("jimi");
        u.setAge(20);
        u.setBirth(new Date());
        LocalDateTime now = LocalDateTime.now();
        u.setCreateTime(now);
        int num = userMapper.insertUser(u);
        System.out.println("num: " + num);
        System.out.println(u);
    }

    @Test
    public void getUserByName() {
        User u = userMapper.getUserByName("o");
        System.out.println(u);
        System.out.println("#######测试缓存#######");
        User u2 = userMapper.getUserByName("o");
        System.out.println(u2);
    }

    @Test
    public void getUsers() {
        ArrayList<User> users = userMapper.getUsers();
        System.out.println(users.size());
        users.forEach(user1 -> System.out.println(user1));
    }

    @Test
    public void getCount() {
        int num = userMapper.getCount();
        System.out.println(num);
    }

    @Test
    public void getLangs() {
        List<Lang> list = userMapper.getLangs();
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    @Test
    public void test1() {
        User u = new User();
        u.setId(1);
        u.setName("mybatis");
        u.setAge(100);
        int num = userMapper.updateById(u);
        System.out.println("num:" + num);
    }

    @Test
    public void test2() {
        User u = new User();
        u.setId(1);
        u.setName("mybatis6");
        u.setAge(100);
        boolean result = userService.updateById(u); //基本类型不能按需更新（int=>Integer）
        System.out.println("result: " + result);
    }
}
