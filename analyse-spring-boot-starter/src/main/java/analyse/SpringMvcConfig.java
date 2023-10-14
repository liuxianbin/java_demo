package analyse;

import analyse.interceptor.AnalyseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // @Configuration的proxyBeanMethods=true,检查bean是否在容器中,如果有就直接获取，没有再创建。
        // 如果没有@Configuration注解或proxyBeanMethods=false,则直接调用analyseInterceptor(),AnalyseInterceptor类中的@Autowired Analyse analyse属性不会自动导入
        System.out.println("********");
        System.out.println(analyseInterceptor() == analyseInterceptor());
        System.out.println("********");
        registry.addInterceptor(analyseInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public AnalyseInterceptor analyseInterceptor() {
        return new AnalyseInterceptor();
    }
}