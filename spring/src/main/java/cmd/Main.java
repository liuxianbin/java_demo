package cmd;

import bean.IAnimal;
import bean.User;
import bean.impl.Dog;
import config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // xml配置bean不写id的话，默认名称为类全限定名#序号 eg:pojo.User#0
        // 通过组件扫描注入bean，默认名称为类名首字符小写 eg: dog
        for (String name : context.getBeanDefinitionNames()) {
            Object b = context.getBean(name);
            System.out.printf("==%-30s  %s\n", name, b);
        }
        // 通过接口类型获取(必须仅有一个实现类，否则报异常NoUniqueBeanDefinitionException)
        IAnimal animal = context.getBean(IAnimal.class);
        animal.display();

        // 开启aop后，实现接口的类不能通过类型获取，报NoSuchBeanDefinitionException异常，此时类型为代理对象bean.impl.Dog@47faa49c
        Dog dog = (Dog) context.getBean(Dog.class);
        dog.display();

        User u = context.getBean(User.class);
        System.out.println(u);
    }
}
