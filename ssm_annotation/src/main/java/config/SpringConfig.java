package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("service")
@PropertySource("classpath:db.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
