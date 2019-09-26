package com.luban.config;

import com.luban.service.Service2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.luban")
@Import(Service2.class)
public class AppConfig {
}
