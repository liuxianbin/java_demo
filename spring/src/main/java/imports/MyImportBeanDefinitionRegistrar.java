package imports;

import bean.Empty;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata md, BeanDefinitionRegistry registry) {
        System.out.println(">>>" + md.getClassName());
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Empty.class).getBeanDefinition();
        registry.registerBeanDefinition("empty_1", beanDefinition);
    }
}
