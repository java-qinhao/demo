package com.luban;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception{
        Class userClass=Class.forName("com.luban.User");
        User user= (User) userClass.newInstance();
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"张三");
        System.out.println(user);

        Constructor[] declaredConstructors = userClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getParameterTypes());
        }
        System.out.println(1);
    }
}
