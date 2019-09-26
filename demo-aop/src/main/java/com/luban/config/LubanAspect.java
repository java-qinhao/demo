package com.luban.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LubanAspect {
    @Pointcut("execution(* com.luban.service.*.*(..))")
    public void pointCut(){

    }
    @Around("pointCut()")
    public Object before(ProceedingJoinPoint pjp) throws Throwable {
       System.out.println("before");
       Object args[]=pjp.getArgs();
       if (args!=null&&args.length>0){
           for (int i = 0; i <args.length ; i++) {
               args[i]+="2222";
           }
       }
        Object O=  pjp.proceed();
        System.out.println(O.toString());
        System.out.println("after");
       return "";
    }
//    @After("pointCut()")
//    public void after(){
//        System.out.println("after");
//    }
}
