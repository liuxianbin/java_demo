package analyse;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties("analyse")
public class AnalyseProperties {
    private String title = "analyse-tool";
}
