package imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata md) {
        System.out.println(">>>"+md.getClassName());
        return new String[]{
                "bean.Empty"
        };
    }
}
