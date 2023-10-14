import bean.IAnimal;
import bean.JdbcProperties;
import config.SpringConfig;
import config.SpringConfig2;
import config.SpringConfig3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Main {
    @Autowired
    JdbcProperties jdbcProperties;


    @Autowired
    @Qualifier("dog")
    IAnimal animal;

    @Test
    public void demo() {
        System.out.println(jdbcProperties);
        animal.display();
    }

    @Test
    public void demo2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig2.class);
        for (String name : context.getBeanDefinitionNames()) {
            Object b = context.getBean(name);
            System.out.printf("==%-30s  %s\n", name, b);
        }
    }

    @Test
    public void demo3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig3.class);
        for (String name : context.getBeanDefinitionNames()) {
            Object b = context.getBean(name);
            System.out.printf("==%-30s  %s\n", name, b);
        }
    }

}
