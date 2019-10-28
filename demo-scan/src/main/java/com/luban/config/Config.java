package com.luban.config;

import com.luban.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com")
public class Config {
//    @Bean
    public UserService userService(){
        return new UserService();
    }
}
