import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class Demo {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-cfg.xml");

    @Test
    public void test1() {
        Object user = context.getBean("user");
        System.out.println(user);
        // NoUniqueBeanDefinitionException
//        User user2 = context.getBean(User.class);
    }

    @Test
    // xml配置bean不写id的话，默认名称为类全限定名#序号 eg:pojo.User#0
    // 通过组件扫描注入bean，默认名称为类名首字符小写 eg: golang
    public void test2() {
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
//            Object b = context.getBean(name);
//            System.out.println(b);
//            System.out.printf("%-20s  %s", name, b);
        }
    }

    @Test
    public void test3() {
        // 工厂bean
        Object u = context.getBean("user2");
        System.out.println(u);
        Object u2 = context.getBean("user3");
        System.out.println(u2);
    }
}
