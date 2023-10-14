package config;

import imports.MyBeanDefinitionRegistryPostProcessor;
import imports.MyImportBeanDefinitionRegistrar;
import imports.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyImportSelector.class, MyBeanDefinitionRegistryPostProcessor.class, MyImportBeanDefinitionRegistrar.class})
public class SpringConfig2 {


}