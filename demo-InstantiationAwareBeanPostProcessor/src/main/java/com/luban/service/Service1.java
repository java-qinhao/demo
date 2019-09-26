package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Service1 {
    @Resource
    Service2 service22;

//    public void setService2111(Service2 service2){
//        this.service2=service2;
//    }
    public void query(){
        System.out.println("query1");
        System.out.println(service22);
    }
}
