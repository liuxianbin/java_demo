package config;

import jakarta.servlet.Filter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// 在Servlet3.0环境中，容器会在类路径中查找实现ServletContainerInitializer接口的类，如果找到的话就用它来配置Servlet容器
// Spring提供了ServletContainerInitializer接口的实现SpringServletContainerInitializer，这个类反过来又查找实现WebApplicationInitializer的类，并将配置的任务交给它来执行
// 使用AbstractAnnotationConfigDispatcherServletInitializer可以简化相同的操作
public class DispatcherServletInit extends AbstractDispatcherServletInitializer {
    @Override
    // 加载SpringMVC对应的bean
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);
        return context;
    }

    @Override
    // 设定SpringMVC对应的请求映射路径
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }

    @Override
    // 加载非SpringMVC对应的bean
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        return context;
    }

    @Override
    protected Filter[] getServletFilters() {
        // 解决POST表单方式中文乱码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("utf-8");
        return new Filter[]{
                characterEncodingFilter,
        };
    }
}
