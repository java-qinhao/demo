package com.luban.config;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class ResubmitDataAspect {
    private static final Cache<String, Object> CACHES = CacheBuilder.newBuilder()
            // 最大缓存 100 个
            .maximumSize(1000)
            // 设置写缓存后 5 秒钟过期
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    @Around("@annotation(com.luban.config.Resubmit)")
    public Object interceptor(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Resubmit localLock = method.getAnnotation(Resubmit.class);
        String key = getKey(pjp.getArgs());
        System.out.println(key);
        if (!StringUtils.isEmpty(key)) {
            if (CACHES.getIfPresent(key) != null) {
                throw new RuntimeException("请勿重复请求");
            }
            // 如果是第一次请求,就将 key 当前对象压入缓存中
            CACHES.put(key, key);
        }
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException("服务器异常");
        } finally {

        }
    }

    /**
     * key 的生成策略,如果想灵活可以写成接口与实现类的方式
     *
     * @param args       参数
     * @return 生成的key
     */
    private String getKey(Object[] args) {
        String str="";
        for (int i = 0; i < args.length; i++) {
            str += args[i].toString();
        }
        return str;
    }
}
