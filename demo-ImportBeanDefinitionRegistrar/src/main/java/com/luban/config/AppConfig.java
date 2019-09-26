package com.luban.config;

import com.luban.annotation.EnableProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luban")
@EnableProxy
public class AppConfig {
}
