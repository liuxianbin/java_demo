package imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorDemo implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String className = importingClassMetadata.getClassName();
        System.out.println("Import当前类 " + className);
        return new String[]{"pojo.Empty"};
    }
}