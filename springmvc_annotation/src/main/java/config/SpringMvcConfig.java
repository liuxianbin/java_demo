package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// 开启SpringMVC多项辅助功能 eg:绑定json请求(@RequestBody)和返回json数据(@ResponseBody)
@EnableWebMvc
@ComponentScan({"controller"})
/*
// SpringMVC的控制层为com.demo.controller,扫描上层包，排除@Controller的bean
@ComponentScan(basePackages = "com.demo",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = Controller.class
        )
)
 */
@Import(SpringMvcSupport.class)
public class SpringMvcConfig {
}