package com.luban.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@MapperScan
public class MyConfiguration {


    @PostConstruct
    public void aa(){
        System.out.println("init");
    }
}
