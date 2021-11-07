package com.doc.doc_backend.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestAspects {
    @Before("execution(* com.doc.doc_backend.*.*(..))")
    public void before(JoinPoint joinPoint) {
        int data = 5 + 5;
        System.out.println("hello world");
    }
}
