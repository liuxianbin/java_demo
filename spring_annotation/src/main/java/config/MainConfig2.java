package config;

import imports.BeanDefinitionRegistryPostProcessorDemo;
import imports.ImportBeanDefinitionRegistrarDemo;
import imports.ImportSelectorDemo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pojo.User;

@Configuration
@Import({User.class, ImportSelectorDemo.class, ImportBeanDefinitionRegistrarDemo.class, BeanDefinitionRegistryPostProcessorDemo.class})
public class MainConfig2 {
}
