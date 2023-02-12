package config;

import com.alibaba.druid.pool.DruidDataSource;
import factory.UserFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //配置项如果不用于被扫描可以省略
// <context:component-scan base-package="pojo,..."/>
@ComponentScan({"pojo", "controller", "service.impl", "factory", "aop"})
// <context:property-placeholder location="db.properties"/>
@PropertySource("classpath:db.properties")
// <tx:annotation-driven transaction-manager="transactionManager"/>
@EnableTransactionManagement
@Import(UserConfig.class) // Import导入的bean名称为全限定名: config.UserConfig
// <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
public class MainConfig {
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;

    @Bean // bean名称默认为方法名
    // dataSource: spring根据类型自动装配
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public UserFactory user3() {
        return new UserFactory();
    }
}