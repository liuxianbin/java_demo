package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 开启SpringMVC多项辅助功能 eg:绑定json请求(@RequestBody)和返回json数据(@ResponseBody)
@EnableWebMvc
@ComponentScan("controller")
// Defines callback methods to customize the Java-based configuration for Spring MVC enabled via @EnableWebMvc.
// @EnableWebMvc-annotated configuration classes may implement this interface to be called back and given a chance to customize the default configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
}
