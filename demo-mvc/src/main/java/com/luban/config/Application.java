package com.luban.config;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Application {
    public static void run(){
        try {
            //初始化spring环境
            AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
            ac.register(AppConfig.class);
            ac.refresh();

            File base=new File(System.getProperty("java.io.tmpdir"));
            Tomcat tomcat=new Tomcat();
            tomcat.getServer().setPort(9090);
            //初始化web环境
            Context rootCtx=tomcat.addContext("/",base.getAbsolutePath());
            DispatcherServlet servlet=new DispatcherServlet(ac);
            //setLoadOnStartup（1）Tomcat会调用DispatcherServlet的init方法
            Tomcat.addServlet(rootCtx,"luban",servlet).setLoadOnStartup(0);
            rootCtx.addServletMapping("/","luban");

            //启动tomcat 并等待
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
