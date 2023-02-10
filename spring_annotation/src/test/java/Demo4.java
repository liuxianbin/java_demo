import config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Demo4 {
    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
//            System.out.println(name);
            Object b = context.getBean(name);
            System.out.println(b);
            System.out.printf("%-20s  %s", name, b);
        }
    }
}
