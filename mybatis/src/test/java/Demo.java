import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Lang;
import pojo.User;
import util.SqlSessionUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setName("jimi");
        u.setAge(20);
        u.setBirth(new Date());
        LocalDateTime now = LocalDateTime.now();
        u.setCreateTime(now);
        int num = user.insertUser(u);
        System.out.println("num: " + num);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(u);
    }

    @Test
    public void getUserByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        User u = user.getUserByName("o");
        sqlSession.close();
        System.out.println(u);
        System.out.println("#######测试缓存#######");
        sqlSession = SqlSessionUtil.getSqlSession();
        user = sqlSession.getMapper(UserMapper.class);
        User u2 = user.getUserByName("o");
        sqlSession.close();
        System.out.println(u2);
    }

    @Test
    public void getUsers() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = user.getUsers();
        sqlSession.close();
        System.out.println(users.size());
        users.forEach(user1 -> System.out.println(user1));
    }

    @Test
    public void getCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        int num = user.getCount();
        sqlSession.close();
        System.out.println(num);
    }

    @Test
    public void getLangs() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper user = sqlSession.getMapper(UserMapper.class);
        List<Lang> list = user.getLangs();
        sqlSession.close();
        list.forEach(System.out::println);
        System.out.println(list.size());
    }
}
