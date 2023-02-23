package com.example.setting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
//@Component  //可以不使用该注解,在导入类中@EnableConfigurationProperties按需注册bean
//via @EnableConfigurationProperties, marked as Spring component, or scanned via @ConfigurationPropertiesScan
@ConfigurationProperties("my")
/*
    导入类中使用@Import(App.class)
        不使用@Component,bean名称为全限定名        com.example.web.setting.App
        使用@Component,bean名称为首字母小写类名     app

    导入类中使用@EnableConfigurationProperties(App.class)
        bean名称为app-com.example.web.setting.App

    若导入类中同时使用@Import和@EnableConfigurationProperties，会注入2个bean
    可以仅使用@ConfigurationProperties，并在导入类中仅使用@EnableConfigurationProperties激活@ConfigurationProperties按需注入bean
 */
public class My {
    private String prefix;
    private String tel;
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timeout;
}
