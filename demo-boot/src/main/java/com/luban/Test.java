package com.luban;

import org.hibernate.validator.constraints.EAN;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@MapperScan("com.luban.dao")
public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class);
    }
}
