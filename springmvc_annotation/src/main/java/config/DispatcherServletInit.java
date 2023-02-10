package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

// AbstractDispatcherServletInitializer: 快速初始化Web3.0容器
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
        return null;
    }

    @Override
    protected Filter[] getServletFilters() {
        //解决中文乱码
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{
                characterEncodingFilter
        };
    }
}
