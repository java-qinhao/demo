package com.luban.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;


public class MyConfiguration {


    @PostConstruct
    public void aa(){
        System.out.println("init");
    }
}
