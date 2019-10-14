package com.luban;

import java.util.Map;

public class User {
    private String name;
    private Integer age;
    User(){

    }
    User(String name,Integer age){
        this.name=name;
        this.age=age;
    }
    public String test(String k1,String k2){
        return "1111";
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
