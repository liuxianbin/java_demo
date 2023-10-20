import config.SpringConfig;
import domain.Charset;
import mapper.HelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Main {
    @Autowired
    HelloMapper helloMapper;

    @Test
    public void m1() {
        Charset c = helloMapper.getCharset("utf8mb4");
        System.out.println(c);
    }
}