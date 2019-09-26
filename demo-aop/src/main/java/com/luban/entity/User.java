package com.luban.entity;

import com.luban.annotation.Entity;

@Entity("t_user")
public class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
