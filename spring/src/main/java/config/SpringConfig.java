package config;

import bean.JdbcProperties;
import bean.User;
import imports.MyBeanDefinitionRegistryPostProcessor;
import imports.MyImportBeanDefinitionRegistrar;
import imports.MyImportSelector;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration配置项如果不用于被扫描可以省略
@Configuration
// <context:component-scan base-package="pojo,..."/>
@ComponentScan({"bean.impl", "aop"})
// <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
// Import导入的bean若未指定bean名称，则名称为全限定名: bean.JdbcProperties
@Import({JdbcProperties.class})

// <tx:annotation-driven transaction-manager="transactionManager"/>
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    // bean名称默认为方法名
    // 这里的jdbc会自动装配
    public User user(JdbcProperties jdbc) {
        User u = new User();
        u.setUsername(jdbc.getUsername());
        return u;
    }
}
