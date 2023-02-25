package com.example.analyse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AnalyseAutoConfiguration.class)
class AnalyseSpringBootStarterApplicationTests {
    @Autowired
    private Analyse analyse;

    @Test
    public void test1() {
        analyse.print2();
    }

}
