package com.example.analyse;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(AnalyseProperties.class)
@Import(Analyse.class)
public class AnalyseAutoConfiguration {
}