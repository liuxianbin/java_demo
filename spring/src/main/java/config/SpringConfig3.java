package config;

import bean.User;
import imports.MyBeanDefinitionRegistryPostProcessor;
import imports.MyImportBeanDefinitionRegistrar;
import imports.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class SpringConfig3 {

    @Bean
    public User uuu() {
        User u = new User();
        u.setUsername("auto");
        return u;
    }

    @Bean
    public A a() {
        A a = new A();
        return a;
    }

    @Bean
    public B b() {
        B b = new B();
        // @Configuration的proxyBeanMethods=true,检查bean是否在容器中,如果有就直接获取，没有再创建。
        // 如果没有@Configuration注解或proxyBeanMethods=false,则直接调用a(),A类中的@Autowired User user属性不会自动导入
        b.setA(a());
        return b;
    }
}