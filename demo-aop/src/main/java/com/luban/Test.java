package com.luban;

import com.luban.config.Appconfig;
import com.luban.dao.UserDao;
import com.luban.service.UserService;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Appconfig.class);
        UserService userService= (UserService) applicationContext.getBean("userServiceImpl");
        userService.query("111");
//        int[] arr={2,4,1,3,5,9,8,6,5,7};
//        for (int i = 0; i <arr.length; i++) {
//            for(int j = 0; j <arr.length-1 ; j++){
//                if(arr[i]<arr[j]){
//                    int a=arr[i];
//                    int b=arr[j];
//                    arr[i]=b;
//                    arr[j]=a;
//                }
//            }
//        }
//        System.out.println(arr);
    }
}
